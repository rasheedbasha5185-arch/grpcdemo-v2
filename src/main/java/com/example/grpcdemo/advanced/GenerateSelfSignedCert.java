package com.example.grpcdemo.advanced;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Date;

public class GenerateSelfSignedCert {

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        long now = System.currentTimeMillis();
        Date startDate = new Date(now);
        Date endDate = new Date(now + 365L * 24 * 60 * 60 * 1000); // 1 year

        X500Name dnName = new X500Name("CN=localhost");
        BigInteger certSerialNumber = BigInteger.valueOf(now);

        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA")
                .build(keyPair.getPrivate());

        X509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(
                dnName, certSerialNumber, startDate, endDate, dnName, keyPair.getPublic());

        X509CertificateHolder certHolder = certBuilder.build(signer);
        X509Certificate certificate = new JcaX509CertificateConverter()
                .setProvider("BC").getCertificate(certHolder);

        // ✅ Create output folder if missing
        File certDir = new File("src/main/resources/certs");
        if (!certDir.exists()) certDir.mkdirs();

        // ✅ Write private key to PEM
        try (JcaPEMWriter pemWriter = new JcaPEMWriter(new FileWriter("src/main/resources/certs/server.pem"))) {
            pemWriter.writeObject(keyPair.getPrivate());
        }

        // ✅ Write public certificate to CRT
        try (JcaPEMWriter certWriter = new JcaPEMWriter(new FileWriter("src/main/resources/certs/server.crt"))) {
            certWriter.writeObject(certificate);
        }

        System.out.println("✅ Self-signed certificate and private key generated successfully!");
        System.out.println("📁 Location: src/main/resources/certs/");
    }
}

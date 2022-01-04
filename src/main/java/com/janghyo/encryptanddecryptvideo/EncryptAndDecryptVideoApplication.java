package com.janghyo.encryptanddecryptvideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.SecureRandom;

@SpringBootApplication
public class EncryptAndDecryptVideoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EncryptAndDecryptVideoApplication.class, args);

        //secretKey는 꼭 32 byte (영문기준 32글자), IV는 16 byte 로 정의
        String key = "oingisprettyintheworld1234567890"; //32 byte
        File inputFile = new File("resource","test.mp4");
        File encryptedFile = new File("resource","test_crypted.mp4");
        File decryptedFile = new File("resource","test_decrypted.mp4");

        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}

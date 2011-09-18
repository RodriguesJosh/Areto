package com.netty.net.packet.login;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class RSA {

	public static void main(String[] args) {
		KeyFactory keyFactory = null;
		KeyPairGenerator keyPairGenerator = null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
		keyPairGenerator.initialize(1024);
		KeyPair keypair = keyPairGenerator.genKeyPair();
		PrivateKey privateKey = keypair.getPrivate();
		PublicKey publicKey = keypair.getPublic();
		RSAPrivateKeySpec rsaPrivateKey = null;
		try {
			rsaPrivateKey = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
		} catch (InvalidKeySpecException ikse) {
			ikse.printStackTrace();
		}
		RSA.writeKey("rsapriv", rsaPrivateKey.getModulus(), rsaPrivateKey.getPrivateExponent());
		RSAPublicKeySpec rsaPublicKey = null;
		try {
			rsaPublicKey = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
		} catch (InvalidKeySpecException ikse) {
			ikse.printStackTrace();
		}
		RSA.writeKey("rsapub", rsaPublicKey.getModulus(), rsaPublicKey.getPublicExponent());
	}

	public static void writeKey(String file, BigInteger modulus, BigInteger exponent) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("./data/rsa/" + file));
			writer.write("private static final BigInteger RSA_MODULUS = new BigInteger(\"" + modulus.toString() + "\");");
			writer.newLine();
			writer.newLine();
			writer.write("private static final BigInteger RSA_EXPONENT = new BigInteger(\"" + exponent.toString() + "\");");
			writer.newLine();
			writer.flush();
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
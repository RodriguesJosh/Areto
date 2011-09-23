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

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:22:40 PM
 */
public class RSA {

	/**
	 * 
	 * @param args
	 * 			The id to set.
	 */
	public static void main(String[] args) {
		KeyFactory keyFactory = null;
		KeyPairGenerator keyPairGenerator = null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
		if (keyFactory == null) {
			return;
		}
		if (keyPairGenerator == null) {
			return;
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
		if (rsaPrivateKey == null) {
			return;
		}
		RSA.writeKey("rsapriv", rsaPrivateKey.getModulus(), rsaPrivateKey.getPrivateExponent());
		RSAPublicKeySpec rsaPublicKey = null;
		try {
			rsaPublicKey = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
		} catch (InvalidKeySpecException ikse) {
			ikse.printStackTrace();
		}
		if (rsaPublicKey == null) {
			return;
		}
		RSA.writeKey("rsapub", rsaPublicKey.getModulus(), rsaPublicKey.getPublicExponent());
	}

	/**
	 * 
	 * @param file
	 * 			The id to set.
	 * @param modulus
	 * 			The id to set.
	 * @param exponent
	 * 			The id to set.
	 */
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
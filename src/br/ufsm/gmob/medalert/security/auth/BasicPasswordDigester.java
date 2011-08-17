package br.ufsm.gmob.medalert.security.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.Normalizer;

import android.util.Log;

public class BasicPasswordDigester implements PasswordDigester {
	
	private static int DEFAULT_ROUND_NUM = 1000;
	private static int DEFAULT_SALT_BYTES_NUM = 16;
	
	public DigestedPassInfo digest(String password, byte[] salt, int rounds) {
		MessageDigest digester = null;
		try {
			digester = MessageDigest.getInstance("SHA-512");
			String normalized_pass = Normalizer.normalize(password, Normalizer.Form.NFC);
			String salted = salt + normalized_pass;
			
			digester.update(salted.getBytes());
			for(int nrounds = 0; nrounds < rounds; nrounds++) {
				digester.update(salted.getBytes()); 
			}
			
			return new DigestedPassInfo(digester.digest(), salt, rounds);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			Log.e(BasicPasswordDigester.class.getName(), "Failed to find SHA-512 hash algorithm.");
			return null;
		}
	}
	
	public DigestedPassInfo digest(String password) {
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			return digest(password, random.generateSeed(DEFAULT_SALT_BYTES_NUM), DEFAULT_ROUND_NUM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			Log.e(BasicPasswordDigester.class.getName(), "Failed to find SHA1PRNG secure random algorithm.");
			return null;
		}
	}
}

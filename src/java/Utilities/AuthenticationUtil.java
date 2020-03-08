/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author micha
 */
public class AuthenticationUtil {
        private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    public String generateSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
    public String generateUserId(int length) {
        return generateSalt(length);
    }
    public String generateSecurePassword(String password, String salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        return Base64.getEncoder().encodeToString(securePassword);
    }
    private byte[] hash(char[] password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
    public SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        SecretKey returnValue = null;
        KeyGenerator secretKeyGenerator = KeyGenerator.getInstance("DESede");
        secretKeyGenerator.init(112);
        returnValue = secretKeyGenerator.generateKey();
        return returnValue;
    }
    public byte[] encrypt(String securePassword, String accessTokenMaterial) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return hash(securePassword.toCharArray(), accessTokenMaterial.getBytes());
    }
 
    
}

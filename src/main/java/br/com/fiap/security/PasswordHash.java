package br.com.fiap.security;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordHash {

    public static String hashPassword(String plainPassword) {
        return BCrypt.withDefaults().hashToString(12, plainPassword.toCharArray());
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.verifyer().verify(plainPassword.toCharArray(), hashedPassword).verified;
    }

}

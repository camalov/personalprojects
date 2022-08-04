package com.company.resume.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BCryptUtil {

    public static byte[] hashPassword(String pass) {
        BCrypt.Hasher bCrypt = BCrypt.withDefaults();
        byte[] hashedPass = bCrypt.hash(7, pass.toCharArray());
        return hashedPass;
    }
}

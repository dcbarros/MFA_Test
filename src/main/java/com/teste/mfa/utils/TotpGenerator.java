package com.teste.mfa.utils;

import com.warrenstrange.googleauth.GoogleAuthenticator;

public class TotpGenerator {
    public static String generateTotpCode(String secretKey) {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        return String.valueOf(gAuth.getTotpPassword(secretKey));
    }
}

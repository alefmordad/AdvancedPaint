package main.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String getMD5String(byte[] bytes) {
        byte[] md5Bytes = md.digest(bytes);
        return byteArrayToString(md5Bytes);
    }

    private static String byteArrayToString(byte[] md5Bytes) {
        BigInteger bigInteger = new BigInteger(1, md5Bytes);
        String hashString = bigInteger.toString(16);
        hashString = makeDigitsFixedToI(hashString, 32);
        return hashString;
    }

    private static byte[] stringToByteArray(String str) {
        return str.getBytes();
    }

    public static String getMD5String(String str) {
        byte[] strBytes = stringToByteArray(str);
        return getMD5String(strBytes);
    }

    private static String makeDigitsFixedToI(String hashText, int i) {
        StringBuilder hashTextBuilder = new StringBuilder(hashText);
        while (hashTextBuilder.length() < i)
            hashTextBuilder.insert(0, "0");
        hashText = hashTextBuilder.toString();
        return hashText;
    }

}

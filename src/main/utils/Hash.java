package main.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    private static MessageDigest md;
    private static BigInteger bigInteger;
    private static String hashString;
    private static byte[] md5Bytes;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String getMD5String(byte[] bytes) {
        md5Bytes = md.digest(bytes);
        return byteArrayToString(md5Bytes);
    }

    public static String byteArrayToString(byte[] md5Bytes) {
        bigInteger = new BigInteger(1, md5Bytes);
        hashString = bigInteger.toString(16);
        hashString = makeDigitsFixedToI(hashString, 32);
        return hashString;
    }

    public static byte[] stringToByteArray(String str) {
        return str.getBytes();
    }

    public static String getMD5String(String str) {
        byte[] strBytes = stringToByteArray(str);
        return getMD5String(strBytes);
    }

    public static String makeDigitsFixedToI(String hashText, int i) {
        while (hashText.length() < i)
            hashText = "0" + hashText;
        return hashText;
    }

}

package Lib.Helper;

import java.security.MessageDigest;
import java.util.Base64;

public abstract class MD5 {
    /**
     * Cipher for encode
     */
    private static final MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("MD5", "SUN");
        } catch (Exception se) {
            throw new SecurityException("In MD5 constructor " + se);
        }
    }

    public static String encode(String in) throws Exception {
        if (in == null) {
            return null;
        }
        try {
            byte[] raw = null;
            byte[] stringBytes = null;
            stringBytes = in.getBytes("UTF8");
            synchronized (md) {
                raw = md.digest(stringBytes);
            }
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(raw);
        } catch (Exception se) {
            throw new Exception("Exception while encoding " + se);
        }

    }

    public static String decode(String in) {
        throw new RuntimeException("NOT SUPPORTED");
    }
}
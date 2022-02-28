package Lib.Helper;

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public class MD5 {
    /**
     * Cipher for encode
     */
    private final MessageDigest md;

    public MD5() throws SecurityException {
        try {
            md = MessageDigest.getInstance("MD5", "SUN");
        } catch (Exception se) {
            throw new SecurityException("In MD5 constructor " + se);
        }
    }

    public String encode(String in) throws Exception {
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
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(raw);
        } catch (Exception se) {
            throw new Exception("Exception while encoding " + se);
        }

    }

    public String decode(String in) {
        throw new RuntimeException("NOT SUPPORTED");
    }
}
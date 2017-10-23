package com.zzsong.study.orange.common.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * MD5 encode
 * Created by zzsong on 2017/7/30.
 */
public class MD5Hash {
    /**
     * When we encode strings, we always specify UTF8 encoding
     */
    private static final String UTF8_ENCODING = "UTF-8";

    /**
     * When we encode strings, we always specify UTF8 encoding
     */
    private static final Charset UTF8_CHARSET = Charset.forName(UTF8_ENCODING);
    private static final int MD5_LEN = 16;

    private static final ThreadLocal<MessageDigest> DIGESTER_FACTORY = ThreadLocal.withInitial(() -> {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    });

    private static final char[] HEX_DIGITS =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static int charToNibble(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'a' && c <= 'f') {
            return 0xa + (c - 'a');
        } else if (c >= 'A' && c <= 'F') {
            return 0xA + (c - 'A');
        } else {
            throw new RuntimeException("Not a hex character: " + c);
        }
    }

    private byte[] digest;

    /**
     * Constructs an MD5Hash.
     */
    public MD5Hash() {
        this.digest = new byte[MD5_LEN];
    }

    /**
     * Constructs an MD5Hash from a hex string.
     */
    public MD5Hash(String hex) {
        setDigest(hex);
    }

    /**
     * Constructs an MD5Hash with a specified value.
     */
    private MD5Hash(byte[] digest) {
        if (digest.length != MD5_LEN)
            throw new IllegalArgumentException("Wrong length: " + digest.length);
        this.digest = digest;
    }

    /**
     * Create a thread local MD5 digester
     */
    private static MessageDigest getDigester() {
        MessageDigest digester = DIGESTER_FACTORY.get();
        digester.reset();
        return digester;
    }

    /**
     * Construct a hash value for a byte array.
     */
    private static MD5Hash digest(byte[] data) {
        return digest(data, 0, data.length);
    }

    /**
     * Construct a hash value for a byte array.
     */
    private static MD5Hash digest(byte[] data, int start, int len) {
        byte[] digest;
        MessageDigest digester = getDigester();
        digester.update(data, start, len);
        digest = digester.digest();
        return new MD5Hash(digest);
    }

    /**
     * Construct a hash value for a String.
     */
    public static MD5Hash digest(String string) {
        return digest(string.getBytes(UTF8_CHARSET));
    }

    /**
     * Get a MD5 string value
     */
    public static String md5(String string) {
        if (string == null || string.trim().equals("")) {
            return "";
        }
        try {
            return digest(string.getBytes(UTF8_CHARSET)).toString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Sets the digest value from a hex string.
     */
    private void setDigest(String hex) {
        if (hex.length() != MD5_LEN * 2)
            throw new IllegalArgumentException("Wrong length: " + hex.length());
        byte[] digest = new byte[MD5_LEN];
        for (int i = 0; i < MD5_LEN; i++) {
            int j = i << 1;
            digest[i] = (byte) (charToNibble(hex.charAt(j)) << 4 | charToNibble(
                    hex.charAt(j + 1)));
        }
        this.digest = digest;
    }

    /**
     * Returns a string representation of this object.
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(MD5_LEN * 2);
        for (int i = 0; i < MD5_LEN; i++) {
            int b = digest[i];
            buf.append(HEX_DIGITS[(b >> 4) & 0xf]);
            buf.append(HEX_DIGITS[b & 0xf]);
        }
        return buf.toString();
    }

    /**
     * Returns true iff <code>o</code> is an MD5Hash whose digest contains the
     * same values.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MD5Hash)) return false;
        MD5Hash other = (MD5Hash) o;
        return Arrays.equals(this.digest, other.digest);
    }

    /**
     * Returns a hash code value for this object.
     * Only uses the first 4 bytes, since md5s are evenly distributed.
     */
    @Override
    public int hashCode() {
        return quarterDigest();
    }

    /**
     * Return a 32-bit digest of the MD5.
     *
     * @return the first 4 bytes of the md5
     */
    private int quarterDigest() {
        int value = 0;
        for (int i = 0; i < 4; i++)
            value |= ((digest[i] & 0xff) << (8 * (3 - i)));
        return value;
    }
}

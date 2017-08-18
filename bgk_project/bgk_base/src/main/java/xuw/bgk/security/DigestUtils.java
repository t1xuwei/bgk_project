/**
 * @(#)DigestUtils.java
 *
 * @author xuji
 * @version 1.0 2014-7-9
 *
 * Copyright (C) 2012,2014 , PING' AN, Inc.
 */
package xuw.bgk.security;

import java.security.MessageDigest;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class DigestUtils
{
    public static byte[] hash(byte[] message, String alg) throws Exception
    {
        MessageDigest md = MessageDigest.getInstance(alg);
        md.update(message);
        return md.digest();
    }

    public static String md5(byte[] message, boolean b64Encoded) throws Exception
    {
        byte[] data = hash(message, "MD5");
        
        if (b64Encoded)
        {
            return new String(Base64.encode(data));
        }
        else
        {
            return HexUtils.byte2Hex(data);
        }
    }
    
    public static String sha1(byte[] message, boolean b64Encoded) throws Exception
    {
        byte[] data = hash(message, "SHA1");
        
        if (b64Encoded)
        {
            return new String(Base64.encode(data));
        }
        else
        {
            return HexUtils.byte2Hex(data);
        }
    }
    
    public static String md5(byte[] message) throws Exception
    {
        return md5(message, false);
    }
    
    public static String sha1(byte[] message) throws Exception
    {
        return sha1(message, false);
    }
}



/**
 * $Log: DigestUtils.java,v $
 * 
 * @version 1.0 2014-7-9 
 *
 */
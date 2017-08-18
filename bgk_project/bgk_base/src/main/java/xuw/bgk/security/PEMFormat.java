/**
 * @(#)PEMFormat.java
 *
 * @author xuji
 * @version 1.0 2014-7-9
 *
 * Copyright (C) 2012,2014 , PING' AN, Inc.
 */
package xuw.bgk.security;


/**
 * 转换证书格式，PEM <--> BER
 * 
 * @author xuji
 * @version 0.9
 * @since 0.9
 */
public class PEMFormat
{
    private static final String PRIVATEKEY_FORMAT_HEAD = "-----BEGIN RSA PRIVATE KEY-----";
    private static final String PRIVATEKEY_FORMAT_TAIL = "-----END RSA PRIVATE KEY-----";
    private static final String CERT_FORMAT_HEAD = "-----BEGIN CERTIFICATE-----";
    private static final String CERT_FORMAT_TAIL = "-----END CERTIFICATE-----";
    private static final String CERT_REQUEST_FORMAT_HEAD = "-----BEGIN CERTIFICATE REQUEST-----";
    private static final String CERT_REQUEST_FORMAT_TAIL = "-----END CERTIFICATE REQUEST-----";

    /**
     * 转换PEM格式的证书请求为BER格式
     * 
     * @param pemCertReq
     * @return
     */
    public static final String certReqPEM2BER(String pemCertReq)
    {
        return readContext(pemCertReq, CERT_REQUEST_FORMAT_HEAD, CERT_REQUEST_FORMAT_TAIL);
    }

    /**
     * 转换PEM格式的证书为BER格式
     * 
     * @param pemCertReq
     * @return
     */
    public static final String certPEM2BER(String pemCertReq)
    {
        return readContext(pemCertReq, CERT_FORMAT_HEAD, CERT_FORMAT_TAIL);
    }
    
    /**
     * 将私钥由PEM转换为BER格式
     */
    public static String privateKeyPEM2BER(String value)
    {
        return readContext(value, PRIVATEKEY_FORMAT_HEAD, PRIVATEKEY_FORMAT_TAIL);
    }

    private static final boolean ignore(char c)
    {
        return (c == '\n' || c == '\r' || c == '\t' || c == ' ');
    }

    private static final String readContext(String s, String beginMarker, String endMarker)
    {
        int begin = s.indexOf(beginMarker);
        int end = s.indexOf(endMarker);

        if (begin < 0 || end < 0)
            return s;

        if (begin >= 0)
        {
            begin += beginMarker.length();
            while (ignore(s.charAt(begin)) && begin < s.length())
            {
                begin++;
            }
        }

        if (end > 1)
        {
            while (ignore(s.charAt(end - 1)) && end > 1)
                end--;
        }
        return s.substring(begin, end);
    }

    /**
     * 将私钥由BER转换为PEM格式
     */
    public static String privateKeyBER2PEM(String value)
    {
        String head = PRIVATEKEY_FORMAT_HEAD;
        String tail = PRIVATEKEY_FORMAT_TAIL;
        return format(value, head, tail);
    }
    
    

    /**
     * 将证书由BER转换为PEM格式
     */
    public static String certBER2PEM(String value)
    {
        String head = CERT_FORMAT_HEAD;
        String tail = CERT_FORMAT_TAIL;
        return format(value, head, tail);
    }

    /**
     * 将证书请求由BER转换为PEM格式
     */
    public static String certRequestBER2PEM(String value)
    {
        String head = CERT_REQUEST_FORMAT_HEAD;
        String tail = CERT_REQUEST_FORMAT_TAIL;
        return format(value, head, tail);
    }

    public static String format(String value, String head, String tail)
    {
        StringBuffer newValue = new StringBuffer();
        newValue.append(head);
        newValue.append("\n");
        while (value.length() > 64)
        {
            newValue.append(value.substring(0, 64));
            value = value.substring(64);
            newValue.append("\n");
        }
        if (value.length() > 0)
        {
            newValue.append(value);
            newValue.append("\n");
        }
        newValue.append(tail);
        newValue.append("\n");
        return newValue.toString();
    }
}


/**
 * $Log: PEMFormat.java,v $
 * 
 * @version 1.0 2014-7-9 
 *
 */
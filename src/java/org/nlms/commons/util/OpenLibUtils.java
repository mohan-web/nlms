package org.nlms.commons.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenLibUtils
{
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toString(Object object)
    {
        String str = null;

        try
        {
            str = mapper.writeValueAsString(object);
        }
        catch (JsonProcessingException e)
        {
            str = "" + object;
        }

        return str;
    }

    public static int getInt(String str)
    {
        return getInt(str, 0);
    }

    public static int getInt(String str, int defaultValue)
    {
        int result = defaultValue;

        try
        {
            result = Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            // Do nothing
        }

        return result;
    }

    public static String getPasswordHash(String password)
    {
        String passwordHash = null;

        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            passwordHash = Base64.encodeBase64URLSafeString(md.digest(password.getBytes()));
        }
        catch (NoSuchAlgorithmException e)
        {
            passwordHash = password;
        }

        return passwordHash;
    }

    public static Object clone(Object object)
    {
        return SerializationUtils.bytesToObject(SerializationUtils.objectToBytes(object));
    }
}

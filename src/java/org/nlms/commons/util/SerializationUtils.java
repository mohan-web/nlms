package org.nlms.commons.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author Prakash K
 */
public class SerializationUtils
{
    public static byte[] objectToBytes(Object object)
    {
        byte[] result = null;

        try
        {
            // Serialize to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(object);
            out.close();

            // Get the bytes of the serialized object
            result = bos.toByteArray();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static Object bytesToObject(byte bytes[])
    {
        Object result = null;

        try
        {
            // Deserialize from a byte array
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
            result = in.readObject();
            in.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return result;
    }
}

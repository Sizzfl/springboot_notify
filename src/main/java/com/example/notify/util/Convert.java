package com.example.notify.util;

import java.io.*;

public class Convert
{
    public static byte[] convertObjectToByteArray(Object obj) throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(ObjectOutputStream oos = new ObjectOutputStream(baos))
        {
            oos.writeObject(obj);
            return baos.toByteArray();
        }
    }

    public static Object convertByteArrayToObject(byte[] bytes) throws IOException, ClassNotFoundException
    {
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is))
        {
            return ois.readObject();
        }
    }
}

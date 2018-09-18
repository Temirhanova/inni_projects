package ru.innopolis.stx13._7_classLoader.magic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class KingMagicClassLoader extends ClassLoader{
    public KingMagicClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("ru.innopolis.stx13._7_classLoader.magic.Magic")) {
            String dest = "file:D://magic.class";
            byte[] classData = null;
            try (InputStream inputStream  =  new URL(dest).openConnection().getInputStream();
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
                int data = inputStream.read();
                while (data != -1) {
                    byteArrayOutputStream.write(data);
                    data = inputStream.read();
                }
                inputStream.close();
                classData = byteArrayOutputStream.toByteArray();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return defineClass(name, classData, 0, classData.length);
        } else {
            return super.loadClass(name);
        }
    }
}

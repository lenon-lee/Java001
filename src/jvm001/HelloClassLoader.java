package jvm001;

import java.util.Base64;
import java.io.*;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Object obj = new HelloClassLoader().findClass("Hello").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        String xlass = "";
        byte[] bytes = decode255();
        return defineClass(name, bytes, 0 ,bytes.length);
    }

    public byte[] decode64(String xlass) {
        return Base64.getDecoder().decode(xlass);
    }

    public byte[] decode255() {
            byte[] res= {};
            try {
            InputStream in = new FileInputStream("D:/Idea_Projects/Hello.xlass");
            int size = in.available();
            byte[] ins = new byte[size];
            res = new byte[size];
            in.read(ins);
            for (int i = 0; i < size; i++) {
                res[i] = (byte) (ins[i]);
//                res[i] = (byte) (0xff-ins[i]);
            }
//            return res;
        } catch (FileNotFoundException e) {
            System.out.print("D:/Idea_Projects/Hello.xlass Not Found");
        } catch (IOException e) {
            System.out.print("IOException");
        }
        return res;
    }
}

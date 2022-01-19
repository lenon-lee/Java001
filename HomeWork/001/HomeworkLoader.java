package jvm011;

import jvm001.HelloClassLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.lang.reflect.*;

public class HomeworkLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            // 类名称应与源代码中的package名和class名保持一致，与本程序所在包无关
            Object obj = new HomeworkLoader().findClass("Hello").newInstance();
            Method m1 = obj.getClass().getDeclaredMethod("hello");
            Object ret=m1.invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
//                res[i] = (byte) (ins[i]);
                res[i] = (byte) (0xff-ins[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.print("D:/Idea_Projects/Hello.xlass Not Found");
        } catch (IOException e) {
            System.out.print("IOException");
        }
        return res;
    }
}

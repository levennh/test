package jvm;

public class MethodArea extends ClassLoader { //可以用来动态加载类的二进制字节码
    public static void main(String[] args) {
        int j = 0;
        MethodArea methodArea = new MethodArea();
        for (int i = 0; i < 10000; i++) {
            methodArea.defineClass("Class" + i, new byte[]{}, 0, 11);
        }
    }
}
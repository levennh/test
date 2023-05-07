package jvm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@SuppressWarnings(value = "all")
public class StringTable {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";
        String s4 = s1 + s2;
        String s5 = "ab";
        String s6 = s4.intern();

//        System.out.println(s3 == s4);//false
//        System.out.println(s3 == s5);//true
//        System.out.println(s3 == s6);//true

        String x2 = new String("c") + new String("d");
        String s = x2.intern();//将字符串对象放入常量池中,已有不会放入,没有则放入该对象.最终会把串池中的对象返回
        String x1 = "cd";
//        System.out.println(x1 == x2);//false
//        System.out.println("cd" == x2);
//        System.out.println(s == x2);

        read();
    }

    private static void read() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/linux.words")));
            long start = System.nanoTime();
            while (true) {
                String s = bufferedReader.readLine();
                if (s == null) break;
                s.intern();
            }
            System.out.println("cost: " + (System.nanoTime() - start) / 1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

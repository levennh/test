package jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapSpace {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello";

            while (true) {
//                list.add(a);
                a = a + a;
                i++;
//                System.out.println(list);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
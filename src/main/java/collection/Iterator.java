package collection;

import java.util.ArrayList;
import java.util.List;

public class Iterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
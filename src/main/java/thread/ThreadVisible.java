package thread;

import sun.misc.Unsafe;

public class ThreadVisible {
    private static volatile boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop = true;
            System.out.println("modify stop to true");
        }).start();


        foo();
    }

    private static void foo() {
        int i = 0;
        while (!stop) {
            i++;
        }

        System.out.println(i);
        Unsafe unsafe = Unsafe.getUnsafe();

    }
}

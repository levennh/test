package thread;

public class ThreadAtomic {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add();
            }
        }, "thread1").start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sub();
        }, "thread2").start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(balance);
    }

    private static int balance = 10;

    public static void add() {
        int b = balance;
        b += 5;
        balance = b;
    }

    public static void sub() {
        int b = balance;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b -= 5;
        balance = b;
    }
}

package jvm;

public class StackOverFlow {
    private static int count;

    public static void main(String[] args) {
        try {
            method();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println(count);
            }
    }

    private static void method() {
        count++;
        method();
    }
}
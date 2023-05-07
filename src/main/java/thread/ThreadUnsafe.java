package thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ThreadUnsafe {
    public static void main(String[] args) throws NoSuchFieldException {
        balanceField = Account.class.getDeclaredField("balance");

        Account account = new Account();

        while (true) {
            int old = account.balance;
            int newValue = old + 5;
            boolean b = UNSAFE.compareAndSwapInt(account, OFFSET, old, newValue);

            if (b) break;
        }
        Map<Object, Object> map = new HashMap<>();
        map.put(null, null);
    }

    static Field balanceField;
    static final Unsafe UNSAFE = Unsafe.getUnsafe();
    static long OFFSET = UNSAFE.objectFieldOffset(balanceField);

    static class Account {
        volatile int balance = 10;
    }

}
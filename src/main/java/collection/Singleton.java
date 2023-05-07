package collection;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null)
//                    return new Singleton();
//            }
//        }
//        return instance;
//    }
}
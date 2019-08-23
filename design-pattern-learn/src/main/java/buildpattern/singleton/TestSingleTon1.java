package buildpattern.singleton;

public class TestSingleTon1 {

    public static void main(String[] args) {

/*        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(SingleTon.getInstance());
            }).start();
        }*/

        System.out.println("-----------------------------------------");

        /*for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(SingleTon2.getInstance());
            }).start();
        }*/

/*        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(SingleTon3.getInstance());
            }).start();
        }*/

/*        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(SingleTon4.getInstance());
            }).start();
        }*/

/*        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(SingleTon5.INSTANCE.toString());
            }).start();
        }*/

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                synchronized (Object.class) {
                    System.out.println(SingleTon6.getInstance().hashCode());
                    System.out.println(Integer.toHexString(SingleTon6.getInstance().hashCode()));
                    System.out.println(SingleTon6.getInstance().toString());
                }
            }).start();
        }

    }
}

/**
 * 懒汉式：单例模式双检测
 */
class SingleTon {
    private static SingleTon singleTon = null;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}


/**
 * 懒汉式：单例锁方法
 */
class SingleTon2 {
    private static SingleTon2 singleTon2 = null;

    private SingleTon2() {
    }

    public synchronized static SingleTon2 getInstance() {
        if (singleTon2 == null) {
            singleTon2 = new SingleTon2();
        }
        return singleTon2;
    }
}

/**
 * 懒汉式：静态内部类
 */
class SingleTon6 {
    private SingleTon6() {
    }

    private static final class Inner {
        private static final SingleTon6 SINGLE_TON_6 = new SingleTon6();
    }

    public static SingleTon6 getInstance() {
        return Inner.SINGLE_TON_6;
    }
}


/**
 * 饿汉式：直接创建对象
 */
class SingleTon3 {
    private static final SingleTon3 singleTon3 = new SingleTon3();

    private SingleTon3() {
    }

    public static SingleTon3 getInstance() {
        return singleTon3;
    }
}

/**
 * 饿汉式：静态代码块创建对象
 */
class SingleTon4 {
    private static final SingleTon4 SINGLE_TON_4;

    static {
        SINGLE_TON_4 = new SingleTon4();
    }

    public static SingleTon4 getInstance() {
        return SINGLE_TON_4;
    }
}

/**
 * 饿汉式：枚举
 */
enum SingleTon5 {
    INSTANCE;

    @Override
    public String toString() {
        return "SingleTon5{@" + Integer.toHexString(hashCode()) + "}";
    }
}
package designpatterns.creational.singletonpattern;

public class Singleton {

    private static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * using synchronized key for multithreaded environment
     *
     * @return
     */
    public static synchronized Singleton getInstances() {

        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * Double-Checked Locking (Recommended)
     *
     * @return
     */
    public static synchronized Singleton getInstanceDoubleLock() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Somethong is Done.");
    }

}

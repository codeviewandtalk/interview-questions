package MultiThreading;

public class MultipleThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create threads

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread T1 is running.");
            }
        });
        System.out.println(t1.getName());
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread T2 is running.");
            }
        });
        System.out.println(t2.getName());
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread T3 is running.");
            }
        });

        Thread t4= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread T4 is running.");
            }
        });


        // Start thread T1
        t1.start();
        // Ensure that T1 completes before T2 starts
        t1.join();

        // Start thread T2
        t2.start();
        // Ensure that T2 completes before T3 starts
        t2.join();

        // Start thread T3
        t3.start();
        // Ensure that T3 completes before the program exits (optional)
        t3.join();

        t4.start();
        t4.join();

        System.out.println("All threads have finished execution.");
    }
}

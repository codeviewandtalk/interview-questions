package Test;

public class Volatile {
    public static void main(String[] args) {
        Resource res1 = new Resource();
        Resource res2 = new Resource();

        Thread t1 = new Thread(new TaskFixed(res1, res2), "Thread-1");
        Thread t2 = new Thread(new TaskFixed    (res2, res1), "Thread-2");

        t1.start();
        t2.start();
    }
}

class Resource {
    void print(String msg) {
        System.out.println(msg);
    }
}

class Task implements Runnable {
    private Resource r1, r2;

    public Task(Resource r1, Resource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        synchronized (r1) { // Lock first resource
            r1.print(Thread.currentThread().getName() + " locked " + r1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            synchronized (r2) { // Lock second resource
                r2.print(Thread.currentThread().getName() + " locked " + r2);
            }
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "r1=" + r1 +
                ", r2=" + r2 +
                '}';
    }
}

class TaskFixed implements Runnable {
    private Resource r1, r2;

    public TaskFixed(Resource r1, Resource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        synchronized (r1) { // Always acquire locks in the same order
            r1.print(Thread.currentThread().getName() + " locked " + r1);
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (r2) { // Acquire second lock in the same order
                r2.print(Thread.currentThread().getName() + " locked " + r2);
            }
        }
    }
}

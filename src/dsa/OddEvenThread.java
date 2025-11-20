package dsa;

public class OddEvenThread {
    public static void main(String[] args) {
        // Print even and odd using two thread
       int maxNumber = 20;
       NumberPrinter numberPrinter = new NumberPrinter(maxNumber);

       Thread oddThread = new Thread(numberPrinter::printOdd);
       Thread evenThread = new Thread(numberPrinter::printEven);

       oddThread.start();
       evenThread.start();
    }
}

class NumberPrinter {

    private final int max;
    private int current = 1;
    private final Object lock = new Object();

    public NumberPrinter(int max) {
        this.max = max;
    }

    public void printOdd() {
        synchronized (lock) {
            while (current <= max) {
                if (current % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    System.out.println("Odd: " + current);
                    current++;
                    lock.notify();
                }
            }
        }
    }


    public void printEven() {
        synchronized (lock) {
            while (current <= max) {
                if (current % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    System.out.println("Even: " + current);
                    current++;
                    lock.notify();
                }
            }
        }
    }
}
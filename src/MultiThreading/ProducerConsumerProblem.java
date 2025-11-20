package MultiThreading;

import java.util.Arrays;

public class ProducerConsumerProblem {
    private final int[] buffer;
    private int count = 0;
    private int in = 0;
    private int out = 0;

    ProducerConsumerProblem(int size) {
        buffer = new int[size];

    }

    //Producer:Adds an item to buffer

    public synchronized void produce(int item) throws InterruptedException {
        while (count == buffer.length) {
            wait();
        }
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        int item = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        notifyAll();
        return item;
    }

    public static void main(String[] args) {
        final ProducerConsumerProblem buffer = new ProducerConsumerProblem(5); // Buffer size 5

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Producing item");
                    buffer.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException ex) {

            }
        });


        // Consumer

        Thread consume =new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for (int i=0; i<10; i++){

                       int item= buffer.consume();
                        System.out.println("Consuming the item = " + item);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consume.start();

    }
}

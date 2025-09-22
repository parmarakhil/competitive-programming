import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue {


    // implement a thread safe blocking queue
    private Semaphore enqueSemaphore;
    private Semaphore dequeueSemaphore = new Semaphore(0);
    private Queue<Integer> queue = new ArrayDeque<>();

    public BoundedBlockingQueue(int capacity) {
        enqueSemaphore = new Semaphore(capacity);
    }

    public void enqueu(int value) throws InterruptedException {
        enqueSemaphore.acquire();
        queue.offer(value);
        dequeueSemaphore.release();
    }

    public int dequeue() throws InterruptedException {
        dequeueSemaphore.acquire();;
        int value = queue.poll();
        enqueSemaphore.release();
        return value;
    }
}

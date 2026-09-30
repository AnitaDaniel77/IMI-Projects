import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        // Queue backed by LinkedList, FIFO order
        Queue<String> fruitQueue = new LinkedList<>();
        fruitQueue.offer("Apple");  // enqueue, adds to the back
        fruitQueue.offer("Banana");
        fruitQueue.offer("Cherry");
        System.out.println("Queue: " + fruitQueue);

        fruitQueue.poll(); // dequeue, removes and returns the front item
        System.out.println("Queue after dequeue: " + fruitQueue);

        // Real-life example: a customer service line
        Queue<String> customerQueue = new LinkedList<>();
        customerQueue.offer("Customer1");
        customerQueue.offer("Customer2");
        customerQueue.offer("Customer3");
        System.out.println("Current customer queue: " + customerQueue);

        customerQueue.poll(); // serves and removes Customer1
        System.out.println("Customer queue after serving one: " + customerQueue);

        customerQueue.poll(); // serves and removes Customer2
        System.out.println("Final customer queue: " + customerQueue);
    }
}
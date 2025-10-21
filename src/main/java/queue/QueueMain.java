package queue;

import java.util.Stack;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        createQueue();
        reverseQueue();
    }

    private static void reverseQueue() throws Exception {
        QueueDS queueDS = new QueueDS(5);
        System.out.println("Enqueue.....");
        for (int i=0; i<5; i++) {
            queueDS.enqueue(i);
        }
        System.out.println("Queue elements originally were in this order: ");
        queueDS.printElements();

        Stack<Integer> stack = new Stack<>();
        // if the queue is not empty, dequeue from it and push into the stack
        while (!queueDS.isQueueEmpty()){
            stack.push(queueDS.deque());
        }
        // queue must be empty by now
        // in order to reverse the elements of the queue, we need to pop from stack and enqueue to the queue
        while (!queueDS.isQueueFull()){
            queueDS.enqueue(stack.pop());
        }
        System.out.println("Queue elements post reversal are in this order: ");
        queueDS.printElements();
    }

    private static void createQueue() throws Exception {
        QueueDS queueDS = new QueueDS(5);
        System.out.println("Enqueue.....");
        for (int i=0; i<5; i++) {
            queueDS.enqueue(i);
        }
        queueDS.printElements();
        System.out.println("Dequeue.....");
        System.out.print("Queue Elements: ");
        for (int i=0; i<5; i++){
            System.out.print(queueDS.deque() + " ");
        }
    }
}

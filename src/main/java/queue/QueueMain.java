package queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        createQueue();
//        reverseQueue();
//        implementQueueUsingTwoStacks();

        int[] arr = {2,3,2};
        int k=2;
        System.out.println(timeRequiredToBuy(arr, k));

    }

    private static void implementQueueUsingTwoStacks() throws Exception {
        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();
        for (int i=0; i<5; i++){
            queueWithTwoStacks.enqueue(i);
        }

        for (int i=0; i<5; i++){
            System.out.print(queueWithTwoStacks.dequeue());
        }
    }

    private static void reverseQueue() throws Exception {
        QueueCircularDS queueDS = new QueueCircularDS(5);
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
        QueueCircularDS queueDS = new QueueCircularDS(5);
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

    // [2,3,'2']
    public static int timeRequiredToBuy(int[] tickets, int k) throws Exception {
        QueueCircularDS queueCircularDS = new QueueCircularDS(tickets.length);
        for (int ticket : tickets) {
            queueCircularDS.enqueue(ticket);
        }

        int totalTicketNeed = tickets[k];
        int kPosition = k;
        int timeTaken = 0;
        int i=0;
        while (totalTicketNeed != 0){
            int data = queueCircularDS.deque();
            timeTaken++;
            data--;
            kPosition--;
            if (kPosition == i){
                totalTicketNeed--;
            }
            i++;
            if (kPosition < 0){
                kPosition = tickets.length - 1;
            }
            if (data > 0){
                queueCircularDS.enqueue(data);
            }
        }
        return timeTaken;
    }


}

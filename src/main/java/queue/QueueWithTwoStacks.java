package queue;

import java.util.Stack;

public class QueueWithTwoStacks {

    // use stack S1 for enqueue operation
    // use stack S2 for dequeue operation - pop from S1 -> push to S2 -> pop from S2
    Stack<Integer> enqueueStack = new Stack<>();
    Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int data) {
        for (int i = 0; i < 5; i++) {
            enqueueStack.push(i);
        }
    }

    public int dequeue() {
        if (dequeueStack.empty()) {
            while (!enqueueStack.empty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }
}

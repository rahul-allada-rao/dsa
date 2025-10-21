package queue;

public class QueueDS {
    int size =0 ;
    int capacity = 0;
    int front = 0;
    int rear = 0;

    int[] queueArray;

    public QueueDS(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    // enqueue from the rear
    //  4 3 2 1 0 <- rear
    public void enqueue(int data) throws Exception {
        if (isQueueFull()){
            throw new Exception("Queue is full!, nothing to enqueue!");
        }
        queueArray[rear] = data;
        rear = (rear + 1) % capacity; // moving rear to the next
        size++;
    }

    // dequeue from the front
    //  front -> 4 3 2 1 0
    public int deque() throws Exception {
        if (isQueueEmpty()){
            throw new Exception("Queue is empty, nothing to dequeue!");
        }
        int data = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public boolean isQueueEmpty(){
        return (size == 0);
    }

    public boolean isQueueFull(){
        return this.size == this.capacity;
    }

    public int sizeOfQueue(){
        return size;
    }

    public void printElements() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue Elements: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }
}

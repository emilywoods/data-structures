import Exception.FullQueue;
import Exception.EmptyQueue;

public class Queue<E> {
    private int size;
    private int top;
    private int first;
    private E[] elements;

    //enqueue, dequeue, empty, full;

    public Queue(int s){
        first = 0;
        size = s;
        top = -1;

        if (size < 0) {
            throw new IllegalArgumentException();
        }

        elements = (E[]) new Object[size];
    }

    public boolean isEmpty(){
        System.out.println(top == -1);
        return top == -1;
    }

    public boolean isFull(){
        System.out.println(top == size - 1);
        return top == size - 1;
    }

    public void enqueue(E element){
        if (top == size - 1) {
            throw new FullQueue();
        }
        elements[++top] = element;
        System.out.println(elements[top]);
    }

    public void dequeue(){
        if (top == -1) {
            throw new EmptyQueue();
        }
        elements[first] = elements[first + 1];
        System.out.println(elements[first]);
    }

    public static void main(String[] arg){
        Queue newQueue = new Queue(10);
        newQueue.enqueue(8);
        newQueue.enqueue(1);
        newQueue.enqueue(5);
        newQueue.isEmpty();
        newQueue.isFull();
        newQueue.dequeue();
    }
}

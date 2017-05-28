import Exception.FullQueue;
import Exception.EmptyQueue;

public class Queue<E> {
    private int size;
    private int top;
    private int first;
    public E[] elements;

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
        return top == -1;
    }

    public boolean isFull(){
        return top == size - 1;
    }

    public void enqueue(E element){
        if (top == size - 1) {
            throw new FullQueue();
        }
        elements[++top] = element;
    }

    public void dequeue(){
        if (top == -1) {
            throw new EmptyQueue();
        }
        elements[first] = elements[first + 1];
        elements[first + 1] = null;
    }
}

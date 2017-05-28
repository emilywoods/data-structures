import Exception.EmptyStack;
import Exception.FullStack;

public class Stack<E> {
    private int size;
    private int top;
    public E[] elements;

    public Stack(int s){
        top = -1;
        size = s;
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

    public void push(E element){
        if (top == size - 1) {
            throw new FullStack();
        }
        elements[++top] = element;
    }

    public void pop(){
        if (top == -1) {
            throw new EmptyStack();
        }
        elements[top] = null;
    }

}

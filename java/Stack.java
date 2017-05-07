import Exception.EmptyStack;
import Exception.FullStack;

public class Stack<E> {
    private int size;
    private int top;
    private E[] elements;

    public Stack(int s){
        top = -1;
        size = s;
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

    public void pop(){
        if (top == -1) {
            throw new EmptyStack();
        }
        elements[top] = elements[--top];
        System.out.println(elements[top]);
    }

    public void push(E element){
        if (top == size - 1) {
            throw new FullStack();
        }
        elements[++top] = element;
        System.out.println(elements[top]);
    }

    public static void main(String[] args){
        Stack newStack = new Stack(10);
        newStack.push(5);
        newStack.isFull();
        newStack.push(7);
        newStack.isFull();
        newStack.push(12);
        newStack.isFull();
        newStack.pop();
        newStack.isEmpty();
        newStack.pop();
        newStack.isEmpty();
    }

}

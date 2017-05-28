import java.util.List;

public class LinkedList<E> {

    public int size;
    public Node<E> head;

    public Node<E> searchWithValue(E value){
        Node<E> currentNode = head;
        while (currentNode != null && currentNode.element != value) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public void insertElementAtHead(E value){
        Node<E> newNode = new Node<> (value);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size ++;
    }

    public void insertElementAtTail(E value) {
        Node<E> newNode = new Node<> (value);

        if (head == null) {
            head = newNode;
        }

        Node<E> temporaryNode = head;
        while(temporaryNode.next != null) {
            temporaryNode = temporaryNode.next;
        }
        temporaryNode.next = newNode;
        size ++;
    }

    public void deleteNode(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (head == null) {
            return;
        }

        Node<E> currentNode = head;

        for (int i = 0; i < index; i++ ) {
            currentNode = currentNode.next;
        }

        if (currentNode.next != null) {
            currentNode.element  = currentNode.next.element;
            currentNode.next = currentNode.next.next;
        } else {
            deleteTailElement();
        }
        size --;
    }

    private void deleteTailElement() {
        if (head == null) {
            return;
        }

        Node<E> currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;
        size --;
    }

    public void deleteHeadElement() {
        if (head == null) {
            return;
        }

        head = head.next;
        size --;
    }

    public int size(){
        return size;
    }

    public void traverseList(){
        if (head == null) {
            return;
        }
        System.out.println(head.element);

        Node<E> currentNode = head;
        while (currentNode.next != null && currentNode.next.next != null) {
            System.out.println(currentNode.next.element);
            currentNode = currentNode.next;
        }
    }

    public class Node<T> {
        Node<T> next;
        T element;

        public Node(T element){
            this.element = element;
        }

    }

}

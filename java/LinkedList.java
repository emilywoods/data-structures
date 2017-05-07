public class LinkedList<E> {

    private int size;
    private Node<E> listHead;

    public Node<E> searchWithValue(E value){
        Node<E> currentNode = listHead;
        while (currentNode != null && currentNode.element != value) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public void insertElementAtHead(E value){
        Node<E> newNode = new Node<> (value);
        if (listHead != null) {
            newNode.next = listHead;
        }
        listHead = newNode;
        size ++;
    }

    public void insertElementAtTail(E value) {
        Node<E> newNode = new Node<> (value);

        if (listHead == null) {
            listHead = newNode;
        }

        Node<E> temporaryNode = listHead;
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

        if (listHead == null) {
            return;
        }

        Node<E> currentNode = listHead;

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
        if (listHead == null) {
            return;
        }

        Node<E> currentNode = listHead;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;
        size --;

    }

    private void deleteHeadElement() {
        if (listHead == null) {
            return;
        }

        listHead = listHead.next;
        size --;

    }

    public int size(){
        return size;
    }

    public void traverseList(){
        if (listHead == null) {
            return;
        }
        System.out.println(listHead.element);

        Node<E> currentNode = listHead;
        while (currentNode.next != null && currentNode.next.next != null) {
            System.out.println(currentNode.next.element);
            currentNode = currentNode.next;
        }

    }

    private class Node<T> {
        Node<T> next;
        T element;

        public Node(T element){
            this.element = element;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.print(list.size);
        list.insertElementAtHead(2);
        System.out.println(list.listHead.element);
        list.deleteNode(0);
        list.insertElementAtHead(50);
        list.insertElementAtTail(25);
        list.insertElementAtHead(1);
        list.insertElementAtHead(9);
        System.out.print(list.size);
        list.deleteHeadElement();
        list.deleteTailElement();
        list.traverseList();
        list.deleteNode(1);
        list.traverseList();
    }

}

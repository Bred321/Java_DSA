package Week_3_Linear_Structures.ADT;

public class DoublyLinkedList<T> {
    static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList(){
        head = tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(T item){
        Node<T> node = new Node<>(item);
        if(isEmpty()){
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void removeFirst(){
        if (isEmpty()) return;
    }

    public void addLast(T item){
        Node<T> node = new Node<>(item);
        if(isEmpty()){
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            node = tail;
        }
        size++;
    }
}


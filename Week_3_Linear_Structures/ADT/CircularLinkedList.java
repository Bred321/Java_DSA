package Week_3_Linear_Structures.ADT;

public class CircularLinkedList<T> {
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> tail;
    private int size;

    public CircularLinkedList(){
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(T item){
        Node<T> node = new Node<>(item);
        if(isEmpty()){
            node.next = node;
            tail = node;
        } else {
            node.next = tail.next; // New node points to head
            tail.next = node; // Old tail points to new node
            tail = node; // Update tail to new node
        }
        size++;
    }

    public T removeFirst(){
        if(isEmpty()) return null;
        Node<T> head = tail.next;
        if(head == tail){
            tail = null;
        } else {
            tail.next = head.next;
        }
        size--;
        return head.data;
    }

    public T peekFirst(){
        if(isEmpty()) return null;
        return tail.next.data; // Head is the next of tail
    }
    
}

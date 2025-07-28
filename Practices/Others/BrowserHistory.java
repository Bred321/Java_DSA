package Practices.Others;

public class BrowserHistory {

    private String homepage;
    private DoublyLinkedList<String> linkedList;
    private Node<String> curr;

    public BrowserHistory(String homepage){
        this.homepage = homepage;
        linkedList = new DoublyLinkedList<String>();
        linkedList.addLast(this.homepage);
        curr = linkedList.head;
    }

    public void visit(String url){
        if(curr.next != null) linkedList.removeLast(); 
        linkedList.addLast(url);
        curr = curr.next;
    }

    public String back(){
        curr = curr.prev;
        return curr.data;
    }

   static class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null; // List became empty
        size--;
        return data;
    }

    public void addLast(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T removeLast() {
        if (isEmpty()) return null;
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null; // List became empty
        size--;
        return data;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node<T> addBefore(Node<T> w, T data) {
        if (w == null) return null;

        // Special case: inserting before head
        if (w == head) {
            addFirst(data);
            return head;
        }

        Node<T> newNode = new Node<>(data);
        newNode.prev = w.prev;
        newNode.next = w;

        w.prev.next = newNode;
        w.prev = newNode;

        size++;
        return newNode;
    }

    public Node<T> getNode(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index: " + i);

        Node<T> p;
        if (i < size / 2) {
            p = head;
            for (int j = 0; j < i; j++) {
                p = p.next;
            }
        } else {
            p = tail;
            for (int j = size - 1; j > i; j--) {
                p = p.prev;
            }
        }
        return p;
    }

    public void removeNode(Node<T> node) {
        if (node == null || isEmpty()) return;

        // If node is the only element
        if (head == tail && head == node) {
            head = tail = null;
        }
        // If node is the head
        else if (node == head) {
            head = head.next;
            head.prev = null;
        }
        // If node is the tail
        else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // If node is in the middle
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        size--;
    }

    }
    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}

package Week_3_Linear_Structures.ADT;

public class DoublyLinkedList<T> {
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
}

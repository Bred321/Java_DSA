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

    public void deleteMiddle() {
        if (head == null || head.next == null) {
            head = null;
            size = 0;
            return;
        }

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Remove slow (middle node)
        if (slow.prev != null)
            slow.prev.next = slow.next;
        if (slow.next != null)
            slow.next.prev = slow.prev;

        // Adjust head if needed
        if (slow == head)
            head = slow.next;

        size--;
    }

    public void removeDuplicates() {
        Node<T> curr = head;

        while (curr != null) {
            Node<T> runner = curr.next;
            while (runner != null) {
                if (curr.data.equals(runner.data)) {
                    // Remove runner
                    if (runner.prev != null)
                        runner.prev.next = runner.next;
                    if (runner.next != null)
                        runner.next.prev = runner.prev;
                    size--;
                }
                runner = runner.next;
            }
            curr = curr.next;
        }
    }

    public void reverse() {
        Node<T> curr = head;
        Node<T> temp = null;

        while (curr != null) {
            // Swap prev and next
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev; // originally next
        }

        // Fix head
        if (temp != null) {
            head = temp.prev;
        }
    }

}

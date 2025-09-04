package Week_3_Linear_Structures.ADT;
public class CircularSinglyLinkedList<T> {
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> tail; // tail.next is the head
    private int size;

    public CircularSinglyLinkedList() {
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // O(1): Add to the end (tail)
    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            node.next = node; // point to itself
            tail = node;
        } else {
            node.next = tail.next; // new node points to head
            tail.next = node;      // old tail points to new node
            tail = node;           // new node becomes the tail
        }
        size++;
    }

    // O(1): Remove from the front (head)
    public T removeFirst() {
        if (isEmpty()) return null;

        Node<T> head = tail.next;
        T data = head.data;

        if (tail == head) {
            tail = null; // only one node
        } else {
            tail.next = head.next; // bypass the head
        }
        size--;
        return data;
    }

    // O(n): Remove node by value (first match)
    public boolean remove(T target) {
        if (isEmpty()) return false;

        Node<T> prev = tail;
        Node<T> curr = tail.next;

        for (int i = 0; i < size; i++) {
            if (curr.data.equals(target)) {
                if (curr == tail) {
                    // if removing tail, move it back
                    if (tail == tail.next) {
                        tail = null;
                    } else {
                        tail = prev;
                        tail.next = curr.next;
                    }
                } else {
                    prev.next = curr.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    // O(n): Print all elements from head
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node<T> curr = tail.next; // head
        for (int i = 0; i < size; i++) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // O(1): Peek at front (head)
    public T peekFirst() {
        if (isEmpty()) return null;
        return tail.next.data;
    }

    public void deleteMiddle() {
        if (tail == null || tail.next == tail) {
            tail = null;
            size = 0;
            return;
        }

        Node<T> slow = tail.next;
        Node<T> fast = tail.next;
        Node<T> prev = tail;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Remove slow
        if (slow == tail) tail = prev;
        prev.next = slow.next;

        size--;
    }

    public void removeDuplicates() {
        if (tail == null) return;

        Node<T> curr = tail.next;

        do {
            Node<T> runner = curr;
            while (runner.next != tail.next) {
                if (curr.data.equals(runner.next.data)) {
                    // Remove runner.next
                    if (runner.next == tail) tail = runner;
                    runner.next = runner.next.next;
                    size--;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        } while (curr != tail.next);
    }

    public void reverse() {
        if (tail == null || tail.next == tail) return;

        Node<T> prev = tail;
        Node<T> curr = tail.next;
        Node<T> next;

        do {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != tail.next);

        tail = curr; // update tail to the new last node
    }
}



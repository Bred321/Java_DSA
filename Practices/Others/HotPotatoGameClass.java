package Practices.Others;

public class HotPotatoGameClass {
    public static void main(String[] args){
        HotPotatoGame game = new HotPotatoGame(new String[] {"Alice", "Bob", "Charlie", "Diana", "Eli"});
        String winner = game.play(3);
        System.out.println("Winner is: " + winner); // Might print "Alice"
    }

    private String[] names;
    private CircularSinglyLinkedList<String> game;

    public HotPotatoGameClass(String[] names){
        this.names = names;
        game = new CircularSinglyLinkedList<String>();
        addNames();
        
    }

    public String play(int k){
        int count = 0;
        Node<String> curr = game.tail.next; // head

        while(game.size() > 1){
            if(count == k - 1){
                System.out.println("Eliminate player " + curr.data);
                game.remove(curr.data);
                System.out.println("Remaining players: " + game.size);
                curr = curr.next;
                count = 0;
            }
            curr = curr.next;
            count++;
        }

        return curr.data;
    }

    private void addNames(){
        for(String name: names){
            game.addLast(name);
        }
    }


    static class CircularSinglyLinkedList<T> {
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
    }

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}





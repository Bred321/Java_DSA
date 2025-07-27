package Practices.Others;

public class HotPotatoGame {
    static class Node {
        String name;
        Node next;

        public Node(String name){
            this.name = name;
            this.next = null;
        }
    }

    private Node tail;
    private int size;
    private String[] names;

    public HotPotatoGame(String[] names){
        size = 0;
        tail = null;
        addNames(names);
    }

    public String play(int k){
        int count = 0;
        Node curr = tail.next; // head
        Node prev = tail; // tail

        while(size > 1){
            if(count == k - 1){
                System.out.println("Eliminate player " + curr.name);
                if(curr == tail){
                    if (tail == tail.next){
                        tail = null;
                    } else {
                        tail = prev;
                        tail.next = curr.next;
                    }
                } else {
                    prev.next = curr.next;
                }
                size--;
                System.out.println("Remaining players: " + size);
                curr = curr.next;
                count = 0;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }

        return curr.name;
    }

    private void addNames(String[] names){
        for(int i = 0; i < names.length; i++){
            Node node = new Node(names[i]);
            if(isEmpty()){
                node.next = node;
                tail = node;
            } else {
                node.next = tail.next;
                tail.next = node;
                tail = node;
            }
            size++;
        }
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args){
        HotPotatoGame game = new HotPotatoGame(new String[] {"Alice", "Bob", "Charlie", "Diana", "Eli"});
        String winner = game.play(3);
        System.out.println("Winner is: " + winner); // Might print "Alice"
    }

}





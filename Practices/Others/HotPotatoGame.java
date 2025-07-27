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
    private Node size;
    private String[] names;

    public HotPotatoGame(String[] names){
        this.names = names;
    }
}

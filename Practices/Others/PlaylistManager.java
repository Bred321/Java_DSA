package Practices.Others;


public class PlaylistManager {
    static class Node {
        Song data;
        Node next, prev;

        public Node(Song data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head, tail, current;
    private int size;

    public PlaylistManager(){
        head = tail = current = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(Song data){
        Node node = new Node(data);
        if(isEmpty()){
            head = tail = current = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(Song data){
        Node node = new Node(data);
        if(isEmpty()){
            head = tail = current = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public boolean removeCurrent(){
        if(isEmpty() || current == null) return false;

        if(head == tail){
            head = tail = current = null;
        } else  if(current == head){
            head = head.next;
            head.prev = null;
            current = head;
        } else if (current == tail){
            tail = tail.prev;
            tail.next = null;
            current = tail;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current = current.next;
        }
        size--;
        return true;
    }

    public boolean moveToNext(){
        if (current == tail) return false;
        current = current.next;
        return true;
    }

    public boolean moveToPrev(){
        if (current == head) return false;
        current = current.prev;
        return true;
    }

    public Song getCurrent(){
        if(isEmpty()) return null;
        return current.data;
    }

    public void printListForward(){
        Node p = head;
        while(p != null){
            System.out.print("[" + p.data.title + "] ");
            p = p.next;
        }
    }

    static class Song {
        String title;
        String artist;

        public Song(String title, String artist){
            this.title = title;
            this.artist = artist;
    };
    }
    public static void main(String[] args){
        PlaylistManager playlist = new PlaylistManager();
        playlist.addLast(new Song("Butterfly", "BTS"));
        playlist.addLast(new Song("Shivers", "Ed Sheeran"));
        playlist.addLast(new Song("Stay", "The Kid LAROI"));

        System.out.println(playlist.getCurrent().title);

        playlist.moveToNext();
        System.out.println(playlist.getCurrent().title); // Shivers

        playlist.removeCurrent();
        System.out.println(playlist.getCurrent().title); // Stay

        playlist.moveToPrev();
        System.out.println(playlist.getCurrent().title); // Butterfly

        playlist.printListForward();
    }
}



package Practices.Others;

public class BrowserHistory {
    static class Node {
        String url;
        Node prev, next;

        public Node(String url){
            this.url = url;
            prev = next = null;
        }
    }

    private int size;
    private Node head, tail, current;

    public BrowserHistory(String url){
        size = 0;
        head = tail = null;
        visit(url);
    }

    public void visit(String url){
        Node node = new Node(url);
        if (isEmpty()){
            head = tail = current = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public String back(){
        if(current.prev == null) return null;
        current = current.prev;
        return current.url;
    }     // Go one step back, return current page

    public String forward(){
        if(current.prev == null) return null;
        current = current.prev;
        return current.url;
    }            // Go one step forward, return current page

    public String getCurrentPage(){
        return current.url;
    }    // Return the current URL
    
    private boolean isEmpty(){
        return size == 0;
    }

    private int size(){
        return size;
    }

}

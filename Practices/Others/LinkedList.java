package ADT;

public class LinkedList<T> { 
    // this class is used as a container of data
    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node<T> head;
    
    public LinkedList() {
        size = 0;
        head = null;
    }
    
    public int size() {
        return size;
    }
    
    public void setHead(Node <T> head){
        this.head = head;
    }

    public Node<T> getHead(){
        return head;
    }

    // check whether the linked list is empty or not
    public boolean isEmpty() {
        return size == 0;
    }
    
    // add a new node at the end
    public void add(T item) {
        // construct a new node
        Node<T> node = new Node<T>(item);
        
        // if not empty, add new node at the end 
        if (!isEmpty()) {
            Node<T> curr = head;
            // position the curr at the end
            while(curr.next != null) 
                curr = curr.next;

            // add the new node as the last node
            curr.next = node; 
        }else{ // if empty, add new node at the head
            head = node;    
        }
        size++;
    }
    
    // remove the first node
    public T remove() {
        // make sure the linked list is not empty
        if (isEmpty()) {
            System.out.println("Linked list empty.");
            return null;
        }

        // obtain the removed node data
        T removedData = head.data;
        
        // advance head
        head = head.next;
        size--;

        //return the removed node data
        return removedData;
    }

    // traverse the linked list
    public void traverse(){
        // make sure the linked list is not empty
        if(isEmpty()){
            System.out.println("Linked list empty.");
            return;
        }

        // use curr node to move around
        // position curr node initially to the first node
        // print and advance curr while curr is not null
        Node<T> curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next; // advance curr to the next node
        }
    }

    public void printEverySecond() {
        Node<T> curr = head;
        int index = 0;
        while (curr != null) {
            if (index % 2 == 1) {
                System.out.print(curr.data + " ");
            }
            curr = curr.next;
            index++;
        }
        System.out.println();
    }

    public void deleteMiddle() {
        if (head == null || head.next == null) {
            head = null;
            size = 0;
            return;
        }

        Node<T> slow = head;
        Node<T> fast = head;
        Node<T> prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        System.out.println("Deleted middle node: " + slow.data);
        prev.next = slow.next;
        size--;
    }

    public void removeDuplicates() {
    Node<T> curr = head;

    while (curr != null) {
        Node<T> runner = curr;
        while (runner.next != null) {
            if (curr.data.equals(runner.next.data)) {
                runner.next = runner.next.next;
                size--;
            } else {
                runner = runner.next;
            }
        }
        curr = curr.next;
    }
}
    /*
    public static void main(String[] args) {
        LinkedList<Integer> LL = new LinkedList<Integer>();
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.add(4);
        
        System.out.print("Traverse linked list: ");
        LL.traverse();
        
        System.out.print("\nCalling remove...\n");
        Integer removedData = LL.remove();
        System.out.println("Removed data: " + removedData);

        System.out.print("Traverse linked list: ");
        LL.traverse();
    }
    */
}

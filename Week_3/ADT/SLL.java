package Week_3.ADT;

public class SLL {
    public static void main (String[] args){
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        // Create a loop in the SLL
        n5.next = n2;
        //run(10, n1);
        if(loop(n1)){
            System.out.println("Loop detected");
            run(10, n1);
        } else {
            System.out.print("No loop detected\n");
        }
    }

    static void run(int times, Node start){
        Node node = start;
        int count = 0;
        while (count < times && node != null){
            System.out.print(node.data + " ");
            node = node.next;
            count++;
        }
        System.out.println();
    }

    // Floyd algorithm
    static boolean loop(Node start){
        Node tortoise = start;
        Node hare = start;
        do {
            // Check if the hare reaches the end of the list
            if(hare.next == null){
                return false;
            } else {
                hare = hare.next;
            }
            // Check if the hard reaches the end of the list
            if(hare.next == null){
                return false;
            } else {
                hare = hare.next;
                tortoise = tortoise.next;
            }

        } while(tortoise != hare);

        return true;
    }
}


class Node {
    int data = 0;
    Node next = null;

    public Node(){}

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

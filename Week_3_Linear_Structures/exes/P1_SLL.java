package Week_3_Linear_Structures.exes;

public class P1_SLL {
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
            breakLoop(n1);
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

    // Break loop to remove the loop
    static void breakLoop(Node start){
        //1. Use Floyd algorithm to find the node where tortoise and hare met
        Node tortoise = start;
        Node hare = start;

        do {
            hare = hare.next;
            hare = hare.next;
            tortoise = tortoise.next;
            // Take into account the circular linked list
        } while (tortoise != hare);

        //2. Advance tortoise only to count how many nodes before reaching hare
        int count = 0;
        do {
            tortoise = tortoise.next;
            count++;
        } while(tortoise != hare);
        System.out.println(count);

        //3. Position hare and tortoise to the start of the linked list
        hare = tortoise = hare;

        //4. advance hare by <count> nodes obtained from step 2 to position hare
        // at the correct node
        while(count > 0){
            hare = hare.next;
            count--;
        }

        //5. Advances both hare and tortoise at the same speed until 
        // hare.next == tortoise.next 
        while(tortoise.next != hare.next){
            tortoise = tortoise.next;
            hare = hare.next;
        }
        //6. Remove the loop by setting fast.next to null
        hare.next = null;
    }
}


class Node {
    // Default parameters value
    int data = 0;
    Node next = null;

    public Node(){}

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

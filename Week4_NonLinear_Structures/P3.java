package Week4_NonLinear_Structures;

public class P3 {
    BTNode root;

    public P3(){
        // Initialize the tree structure
        BTNode n1 = new BTNode(1);
        BTNode n5 = new BTNode(5);
        BTNode n3 = new BTNode(3, n1, n5);
        BTNode n9 = new BTNode(9);
        BTNode n13 = new BTNode(13);
        BTNode n11 = new BTNode(11, n9, n13);
        root = new BTNode(7, n3, n11);
    }

    public static void main(String[] args){
        P3 p3 = new P3();
        int foundlevel = p3.findLevel(new BTNode(7));
        if(foundlevel != -1){
            System.out.println("Node found at level: " + foundlevel);
        } else {
            System.out.println("Node not found in the tree.");
        }
    }

    public int findLevel(BTNode node){
        BTNode currentNode = root;
        int levelCount = 0;

        while(currentNode != null){
            if(node.data < currentNode.data){
                currentNode = currentNode.left;
                levelCount += 1;
            } else if(node.data > currentNode.data){
                currentNode = currentNode.right;
                levelCount += 1;
            } else {
                return levelCount;
            }
        }

        return -1; // Node not found
    }



    public int nodeLevel(BSTNode node){
        if(node == root) return 0;

        return nodeLevel(node.parent) + 1;
    }


class BTNode {
    int data;
    BTNode left = null, right = null;

    public BTNode(int data, BTNode left, BTNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BTNode(int data){
        this.data = data;
    }
}

class ArrayQueue<T> {
   private int size = 0;
   private int front;
   private int rear;
   private static int MAX_SIZE = 10;
   private T[] items;

   public ArrayQueue() {
      this.front = this.rear = 0;
      this.items = (T[]) new Object[MAX_SIZE];
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public boolean enQueue(T var1) {
      if (this.size < MAX_SIZE) {
         this.items[this.rear] = var1;
         this.rear = (this.rear + 1) % MAX_SIZE;
         ++this.size;
         return true;
      } else {
         return false;
      }
   }

   public boolean deQueue() {
      if (this.isEmpty()) {
         return false;
      } else {
         this.front = (this.front + 1) % MAX_SIZE;
         --this.size;
         return true;
      }
   }

   public T peekFront() {
      return this.isEmpty() ? null : this.items[this.front];
   }
}
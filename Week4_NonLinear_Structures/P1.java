package Week4_NonLinear_Structures;

public class P1 {
    TreeNode root;

    public P1(){
        // Initialize the tree structure
        TreeNode n1 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3, n1, n5);
        TreeNode n9 = new TreeNode(9);
        TreeNode n13 = new TreeNode(13);
        TreeNode n11 = new TreeNode(11, n9, n13);
        root = new TreeNode(7, n3, n11);
    }
    public static void main(String[] args){
        P1 p1 = new P1();

        System.out.println("Pre-order traversal of the tree: ");
        traversePreOrder(p1.root); // Output: 7 3 1 5 11 9 13

        System.out.println("\nPost-order traversal of the tree: ");
        traversePostOrder(p1.root); // Output: 1 5 3 9 13 11 7

        System.out.println("\nIn-order traversal of the tree: ");
        traverseInOrder(p1.root); // Output: 1 3 5 7 9 11 13

        System.out.println("\nBreadth First traversal of the tree: ");
        traverseBreadthFirst(p1.root); // Output: 1 3 5 7 9 11 13
    }

    static void traversePreOrder(TreeNode node){
        if(node != null){
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    static void traversePostOrder(TreeNode node){
        if(node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    static void traverseInOrder(TreeNode node){
        if(node != null){
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    static void traverseBreadthFirst(TreeNode root){
        ArrayQueue<TreeNode> queue = new ArrayQueue<>();
        if(root != null) queue.enQueue(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.peekFront();
            queue.deQueue();
            System.out.print(" " + node.data);
            if(node.left != null) queue.enQueue(node.left);
            if(node.right != null) queue.enQueue(node.right);
        }
    }
}

class TreeNode{
    int data;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode parent = null;

    public TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.parent = this.right = this.left = null;
        this.right = right;
    }

    public TreeNode(int data){
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


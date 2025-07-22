package Week4_NonLinear_Structures;

public class P4 {
    static TreeNode root;

    public P4(){
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
        P4 p4 = new P4();
        int x = 6;
        System.out.println("\nBreadth First traversal of the tree: ");
        if(searchMinLargerNode(x) != null){
            TreeNode resultNode = searchMinLargerNode(x);
            System.out.println("Node value: " + resultNode.data);
        } else {
            System.out.println("Cannot find a node larger than " + x);
        } // Output: 1 3 5 7 9 11 13
    }

    static TreeNode searchMinLargerNode(int x){
        ArrayQueue<TreeNode> queue = new ArrayQueue<>();
        TreeNode minNode = new TreeNode(0);
        float minDiff = Float.POSITIVE_INFINITY;

        if(root != null) {
            queue.enQueue(root);
            if(root.data - x > 0 && root.data - x < minDiff){
                minDiff = root.data - x;
                minNode = root;
            }
        } 

        while(!queue.isEmpty()){
            TreeNode node = queue.peekFront();
            queue.deQueue();
            if(node.left != null) {
                queue.enQueue(node.left);
            }
            if(node.right != null) {
                queue.enQueue(node.right);
            } 
            if(node.data - x > 0 && node.data - x < minDiff){
                minDiff = node.data - x;
                minNode = node;
            }
        }

        return minNode;
    }
}

class TreeNode{
    int data;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
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
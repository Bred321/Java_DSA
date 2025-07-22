package Week4_NonLinear_Structures;

public class P2 {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3, n1, n5);
        TreeNode n9 = new TreeNode(9);
        TreeNode n13 = new TreeNode(13);
        TreeNode n11 = new TreeNode(11, n9, n13);
        TreeNode root = new TreeNode(7, n3, n11);

        System.out.println("\nBreadth First traversal of the tree: ");
        if(isBinarySearchTree(root)){
            System.out.println("The tree is a Binary Search Tree.");
        } else {
            System.out.println("The tree is NOT a Binary Search Tree.");
        } // Output: 1 3 5 7 9 11 13
    }

    static boolean isBinarySearchTree(TreeNode currentNode){
        ArrayQueue<TreeNode> queue = new ArrayQueue<>();
        int currentData = 0;
        int leftChildData = 0;
        int rightChildData = 0;
        if(currentNode != null) {
            queue.enQueue(currentNode);
            currentData = currentNode.data;
        } 

        while(!queue.isEmpty()){
            TreeNode node = queue.peekFront();
            currentData = node.data;
            queue.deQueue();
            if(node.left != null) {
                queue.enQueue(node.left);
                leftChildData = node.left.data;
                System.out.println("Left child of " + currentData + " is " + leftChildData);
                if(currentData < leftChildData) return false;
            }
            if(node.right != null) {
                queue.enQueue(node.right);
                rightChildData = node.right.data;
                System.out.println("Right child of " + currentData + " is " + rightChildData);
                if(currentData > rightChildData) return false;
            } 
            // Wrong approach
            // if(currentData < leftChildData || currentData > rightChildData){
            //     System.out.println("---Edge case ---");
            //     System.out.println("Left child of " + currentData + " is " + leftChildData);
            //     System.out.println("Right child of " + currentData + " is " + rightChildData);
            //     return false;
            // }
        }

        return true;
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
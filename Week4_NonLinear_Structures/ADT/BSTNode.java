package Week4_NonLinear_Structures.ADT;

public class BSTNode {
    int data;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode parent = null;

    public BSTNode(int data){
        this.data = data;
        this.parent = this.right = this.left = null;
    }
}

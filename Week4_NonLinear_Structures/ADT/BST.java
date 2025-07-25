package Week4_NonLinear_Structures.ADT;


public class BST {
    BSTNode root;

    public BSTNode(){
        root = null;
    }

    // Insert a node into the BST
    public boolean insert(int value) {
        if (root == null) root = new BSTNode(value);
        else {
            BTNode parent = null, current = root;
            while (current != null) {
                if (value < current.data) {
                parent = current;
                current = current.left;
            }
            else if (value > current.data) {
                parent = current;
                current = current.right;
            }
            else return false;
            // already exists, can’t insert
        }

        if (value < parent.data) {
            parent.left = new BTNode(value);
            parent.left.parent = parent;
        } else {
            parent.right = new BTNode(value);
            parent.right.parent = parent;
        }
        }
        size++;
        return true;
    }
}


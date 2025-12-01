public class ValidateBST {
    
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildBST(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val > root.data) {
            root.right = buildBST(root.right, val);
        } else if (val < root.data) {
            root.left = buildBST(root.left, val);
        }
        return root;
    }

    
    

    public static boolean isValidBST(Node root,Node min,Node max) {
        if (root == null) {
            return true;
        }
        else if(min!=null && min.data>=root.data){
            return false;
        }

        else if(max!=null && max.data<=root.data){
            return false;
        }

        return isValidBST(root.left,min,root)&& isValidBST(root.right,root,max);
        
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int val : values) {
            root = buildBST(root, val);
        }

        System.out.println(isValidBST(root,null,null)); // Expected: true
    }
}

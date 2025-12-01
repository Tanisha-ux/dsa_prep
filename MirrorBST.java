public class MirrorBST {
    
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

    
    

    public static Node mirrorBST(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMirror=mirrorBST(root.left);
        Node rightMirror=mirrorBST(root.right);

        root.left=rightMirror;
        root.right=leftMirror;
        return root;
        
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+"  ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.right=new Node(10);
        root.right.right=new Node(11);
        root.left.right=new Node(6);
        root.left.left=new Node(3);

        preOrder(root);
        System.out.println();
        mirrorBST(root);
        preOrder(root);
         // Expected: true
    }


}

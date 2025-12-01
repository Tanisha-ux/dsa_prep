public class TransformToSumTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static int sumTree(Node root){
        if(root==null){
            return 0;
        }

        int leftSumtree=sumTree(root.left);
        int rightSumtree=sumTree(root.right);
        int Data=root.data;

        
        

        root.data=leftSumtree+rightSumtree;
        return root.data+Data;
    }

    public static void main(String args[]){
    Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(sumTree(root));
        
    }
}

public class KthAncestorOfNode {
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
    static boolean found=false;
    public static int kthancestor(Node root,int n,int k){
        if(root==null){
            return 0;
        }
        if(root.data==n){
            return 1;
        }

        int leftDist=kthancestor(root.left,n,k);
        int rightDist=kthancestor(root.right,n,k);

        if(leftDist==-1 && rightDist==-1){
            return -1;
        }

        int max=Math.max(leftDist,rightDist);
        if(max==k && !found){
            System.out.println(root.data);
            found=true;
        }
        return max+1;

    }



    

    public static void main(String args[]){
    Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int n = 5, k = 2;
        kthancestor(root,n,k);
    }
}

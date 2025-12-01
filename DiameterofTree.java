public class DiameterofTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Info{
        int diam;
        int ht;

        Info(int dm,int ht){
            this.diam=dm;
            this.ht=ht;
        }
    }

    public static Info DiaMeter(Node root){

        if(root==null){
            return new Info(0,0);
        }

        Info leftInfo=DiaMeter(root.left);
        Info rightInfo=DiaMeter(root.right);

        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;

        return new Info(diam,ht);
    }
    
    public static void main(String args[]){
       Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        
        Info treeInfo = DiaMeter(root);
        System.out.println("Diameter of the tree is: " + treeInfo.diam);

    }
}

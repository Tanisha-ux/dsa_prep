import java.util.*;

public class BSTtoBalancedBST {
    static class Node{
        int data;
        Node right,left;

        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

        public static void inOrder(Node root,ArrayList<Integer> inorder){
            if(root==null){
                return;
            }
            inOrder(root.left,inorder);
            inorder.add(root.data);
            inOrder(root.right,inorder);
        }

        public static Node createBST(int st,int end,ArrayList<Integer> inorder){
            if(st>end){
                return null;
            }
            int mid=(st+end)/2;
            Node root=new Node(inorder.get(mid));
            root.left=createBST( st, mid-1,inorder);
            
            root.right=createBST( mid+1,end,inorder);

            return root;
    }

    public static Node balanceBST(Node root){
        ArrayList<Integer> inorder=new ArrayList<>();
        inOrder(root,inorder);

        root=createBST(0,inorder.size()-1,inorder);
        return root;
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    

    public static void main(String args[]){
        Node root=new Node(8);
        root.left=new Node(6);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);

        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);

        root=balanceBST(root);
        preorder(root);
    }
}

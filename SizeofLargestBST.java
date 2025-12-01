import java.util.*;

public class SizeofLargestBST {
    static class Node{
        int data;
        Node right,left;

        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    static class Info{
        boolean isBST;
        int min,max,size;

        Info(boolean isBST,int min, int max, int size){
            this.isBST=isBST;
            this.min=min;
            this.max=max;
            this.size=size;
        }
    }
    public static int MaxBST=0;
    public static Info sizeofLargestBST(Node root){
        
        if(root==null){
            return new Info(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);

        }
        Info leftinfo=sizeofLargestBST(root.left);
        Info rightinfo=sizeofLargestBST(root.right);

        int size=leftinfo.size +rightinfo.size +1;
        int min=Math.min(root.data,(Math.min(leftinfo.min,rightinfo.min)));
        int max=Math.max(root.data,(Math.max(leftinfo.max,rightinfo.max)));

        // if(root.data<=leftinfo.max || root.data>=rightinfo.min){
        //     return new Info(false,min,max,size);
        // }

        if(leftinfo.isBST && rightinfo.isBST && root.data > leftinfo.max && root.data < rightinfo.min){
            MaxBST=Math.max(size,MaxBST);
            return new Info(true,min,max,size);
        }
        return new Info(false,min,max,size);
        
        

    }

        

        

    public static void main(String args[]){
        Node root=new Node(50);
        root.left=new Node(30);
        root.left.left=new Node(5);
        root.left.right=new Node(20);

        root.right=new Node(60);
        root.right.left=new Node(45);
        root.right.right=new Node(70);
        root.right.right.right=new Node(80);
        root.right.right.left=new Node(65);
        
        Info info=sizeofLargestBST(root);
        System.out.println(MaxBST);
        System.out.println(info.size);

        
    }


}

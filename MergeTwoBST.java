
import java.util.*;

public class MergeTwoBST {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    
    public static void getInorder(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        getInorder(root.left,list);
        list.add(root.data);
        getInorder(root.right,list);

    }

    public static Node createBST(int st,int end,ArrayList<Integer>arr){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBST(st,mid-1,arr);
        root.right=createBST(mid+1,end,arr);
        
        return root;
        
    }

    public static Node mergeBST(Node root1,Node root2){
         ArrayList<Integer> arr1=new ArrayList<>();
         getInorder(root1,arr1);

         ArrayList<Integer> arr2=new ArrayList<>();
         getInorder(root2,arr2);

         ArrayList<Integer> finalArr=new ArrayList<>();


         int i=0,j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }
            else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }
        
        return createBST(0,finalArr.size()-1,finalArr);


}

    public static void preorder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);

        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);

        Node root=mergeBST(root1,root2);
        preorder(root);

    }
}

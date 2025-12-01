import java.util.*;

public class RootToLeafPath {
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data=data;
        }
    }

    public static Node buildBST(Node root,int val){

            if(root==null){
                root=new Node(val);
                return root;
            }

            if(val>root.data){
                root.right=buildBST(root.right,val);
            }

            if(val<root.data){
                root.left=buildBST(root.left,val);
            }
            return root;

    }

    public static void printPath(Node root, ArrayList<Integer> path){
        for(int i=0;i< path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }
    
    public static void rootToLeafPath(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        
        rootToLeafPath(root.left,path);
        rootToLeafPath(root.right,path);
        if(root.right==null && root.left==null){
            printPath(root,path);
        }
        
        path.remove(path.size()-1);
        

        
    }

    public static void main(String args[]){
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=buildBST(root,values[i]);
        }

        rootToLeafPath(root,new ArrayList<>());
    }


}

import java.util.*;

public class HorizontalDistance {
    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class Info{
        int hd;
        Node node;

        Info(int hd, Node node){
            this.node=node;
            this.hd=hd;
        }
    }

    public static void topView(Node root){
        Queue<Info> q= new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        
        int min=0,max=0;
        q.add(new Info(0,root));
        q.add(null);

        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }

            else{
                if(!map.containsKey(curr.hd)){
                    
                    map.put(curr.hd,curr.node);
                }

                if(curr.node.left!=null){
                    q.add(new Info(curr.hd-1,curr.node.left));
                    min=Math.min(min,curr.hd-1);
                }

                if(curr.node.right!=null){
                    q.add(new Info(curr.hd+1,curr.node.right));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }

        for(int i=min;i<=max;i++){
            System.out.println(map.get(i).data+" ");
        }


    }

    public static void main(String args[]){
        Node root=new Node(1);
        root.right=new Node(3);
        root.left=new Node(2);
        root.left.right=new Node(4);
        root.left.right.right=new Node(5);
        root.left.right.right.right=new Node(6);

        topView(root);
    }


}

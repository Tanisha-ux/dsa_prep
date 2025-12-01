public class SearchinBST {
    
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
    
    public static Node searchInBst(Node root,int key){
        if(root==null){
            return null;
        }
        if(root.data==key){
            return root;
        }

        else if(root.data>key){
            return searchInBst(root.left,key);
        }

        else if(root.data<key){
            return searchInBst(root.right,key);
        }

        return root;
         
    }

    public static void preOrder(Node root){
            if(root==null){
                return;
            }
            System.out.println(root.data+"");
            preOrder(root.left);
            preOrder(root.right);
    }
    

    public static void main(String args[]){
        int val[]={5,1,3,4,2,7};
        Node root =null;
        for(int i=0;i<val.length;i++){
            root=buildBST(root,val[i]);
        }

        int key=4;
        Node res=searchInBst(root,key);
        if(res!=null){
            System.out.println("found");
        }
        else{
            System.out.println("not found");
        }
        // preOrder(root);
        
    }


}

public class DeleteNodeFromBST {
    
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
    

    public static void preOrder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+"  ");
            preOrder(root.left);
            preOrder(root.right);
    }

    public static Node inordersuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static Node Delete(Node root,int val){
        if(root.data>val){
            root.left=Delete(root.left,val);
        }
        else if(root.data<val){
            root.right=Delete(root.right,val);
        }
        else{
            
            if(root.right==null && root.left==null){
                return null;

            }
            else if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                Node Is=inordersuccessor(root.right);
                root.data=Is.data;

                root.right=Delete(root.right,Is.data);
            }

           

        }
         return root;
    }
    

    public static void main(String args[]){
        int val[]={5,1,3,4,2,7};
        Node root =null;
        for(int i=0;i<val.length;i++){
            root=buildBST(root,val[i]);
        }
        preOrder(root);
        Delete(root,4);
        System.out.println();
        preOrder(root);
    }


}

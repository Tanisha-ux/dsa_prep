public class QueueLL {
    public class Node{
        int data;
        Node next;
    

        Node(int data){
           this.data=data;
           this.next=null;
        }
    }
        
        Node head;
        Node tail;
        
        public boolean isEmpty(){
            return head==null && tail==null;
        }

        public void add(int data){
            Node newNode=new Node(data);
            if(head==null && tail==null){
                head=tail=newNode;
            }
            tail.next=newNode;
            tail=newNode;
            
        }

        public int remove(){
            int result=head.data;
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            if(head==tail){
                tail=head=null;
            }
            else{
                head=head.next;
            }
            
            return result;
        }
        
        public int peek(){
            if(isEmpty()){
                System.out.println("empty queue ");
                return -1;
            }
            return head.data;
        
        }
    

    public static void main(String args[]){
       QueueLL q=new QueueLL();
       q.add(5);
       q.add(8);
       q.add(2);

       while(!q.isEmpty()){
        System.out.println(q.peek());
        q.remove();
       }
    }
}

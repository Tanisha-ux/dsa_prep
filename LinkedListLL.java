public class LinkedListLL{
    public static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
            this.next=null;
        }
        
    }
        
        public static Node head;
        public static Node tail;
        public static int size;
        
        public void addFirst(int data){
            Node newNode=new Node(data);
            size++;
            if(head==null){
                head=tail=newNode;
                return;
            }
            
            newNode.next=head;
            head=newNode;
            
        }
        
        public void addLast(int data){
            Node newNode=new Node(data);
            size++;
            if(head==null){
                head=tail=newNode;
                return;
            }
            
            tail.next=newNode;
            tail=newNode;
            
        }
        
        public void addMid(int idx, int data){
            Node newNode=new Node(data);
            
            if(idx==0){
                addFirst(data);
                return;
            }
            Node temp=head;
            int i=0;
            
            while(i<idx-1){
                temp=temp.next;
                i++;
            }
            
            newNode.next=temp.next;
            temp.next=newNode;
        }
        
        public int removeFirst(){
            int val=head.data;
            
            if(size==0){
                System.out.print("LL is empty");
                return Integer.MIN_VALUE;
            }
            
            else if(size==1){
                val=head.data;
                head=tail=null;
                size=0;
                return val;
            }
            
            head=head.next;
            size--;
            return val;
        }
        
        public int removeLast(){
            int i=0,val;
            Node temp=head;
            if(size==0){
                System.out.print("LL is empty");
                return Integer.MIN_VALUE;
            }
            
            else if(size==1){
                val=head.data;
                head=tail=null;
                size=0;
                return val;
            }
            
            while(i<size-2){
                temp=temp.next;
                i++;
                
            }
            
            val=tail.data;
            temp.next=null;
            tail=temp;
            size--;
            return val;
        }
        
        public int removeMid(int idx){
            int val,i=0;
            Node temp=head;
            if(size==0){
                System.out.print("LL is empty");
                return Integer.MIN_VALUE;
            }
            
            else if(size==1){
                val=head.data;
                head=tail=null;
                size=0;
                return val;
            }
            
            while( i<idx-1){
                temp=temp.next;
                i++;
            }
            val=temp.next.data;
            temp.next=temp.next.next;
            size--;
            return val;
            
        }

        public int itrSearch(int element){
            int i=0;
            Node temp=head;
            while(temp!=null){
                if(temp.data==element){
                    return i;
                }
                temp=temp.next;
                i++;
            }
            return -1;
        }

        public int helper(Node head,int key){
            
            if(head==null){
                return -1;
            }
            if(head.data==key){
                return 0;
            }
            int idx=helper(head.next,key);
            if(idx==-1){
                return -1;
            }
            return idx+1;
        }

        public int recSearch(int key){
            return helper(head,key);
        }

        public Node reverse(Node head){
            Node prev=null;
            Node curr=head;
            Node next;
            tail=head;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            
            return prev;
        }

        public void deletenfromend(int n){
            int size=0;
            Node temp=head;
            while(temp!=null){
                temp=temp.next;
                size++;
            }

            if(n==size){
                head=head.next;
                size--;
                return;
            }

            int i=1;
            Node prev=head;
            int iToFind=size-n;
            while(i<iToFind){
                prev=prev.next;
                i++;
            }

            if(prev.next != null){
                prev.next = prev.next.next;
            }
            if(prev.next == null){
               tail = prev;
            }
            size--;



            return;
        }

        public Node findMid(Node head){
            Node slow=head;
            Node fast=head;

            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;

            }
            return slow;
        }

        public boolean checkPalindrome(){
            if(head==null || head.next==null){
                return true;
            }
            Node Mid=findMid(head);
            Node SecondHalf=reverse(Mid);
            

            Node right=SecondHalf;
            Node left=head;
            boolean isPalindrome = true;
            while(right!=null){
                if(left.data!=right.data){
                    isPalindrome = false;
                }
                left=left.next;
                right=right.next;
            }

            System.out.println(reverse(Mid));
            reverse(SecondHalf);
            return isPalindrome;

            
            
        }

        public void removeCycle(){
            Node slow=head;
            Node fast=head;
            boolean isCycle=false;

            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            
                if(fast==slow){
                    isCycle=true;
                    break;
                }
            }

            if(isCycle==false){
                return;
            }

            slow=head;
            Node prev=null;
            while(slow!=fast){
                prev=fast;
                slow=slow.next;
                fast=fast.next;

            }
            prev.next=null;

        }
        
        public void print(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data +"->");
                temp=temp.next;
            }
            
            System.out.print("null");
        }
        
        public static void main(String args[]){
            LinkedListLL ll=new LinkedListLL();
            ll.addFirst(3);
            ll.addFirst(4);
            ll.addFirst(5);
            ll.addFirst(2);
            ll.addFirst(1);
            ll.addFirst(0);
            ll.addMid(2,-1);
            ll.addLast(3);
            System.out.println(ll.itrSearch(3));
            System.out.println(ll.recSearch(3));
            ll.removeCycle();
            
            
            System.out.println(ll.checkPalindrome());
            ll.print();
        }
        
}
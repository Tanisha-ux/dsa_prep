import java.util.LinkedList;

public class LinkedList2 {
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
    

    public Node getMid(Node head){
         if (head == null || head.next == null) return head;
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
 
    }

    public void zigZag(){
        Node mid=getMid(head);
        Node next;
        Node prev=null;

        Node curr=mid.next;
        mid.next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node leftHead=head;
        Node rightHead=prev;
        Node nextL,nextR;

        while(leftHead!=null && rightHead!=null){
            nextL=leftHead.next;
            leftHead.next=rightHead;
            nextR=rightHead.next;
            rightHead.next=nextL;

            leftHead=nextL;
            rightHead=nextR;

        }
    }

    public Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while (head1 != null && head2 != null) {
        if(head1.data<head2.data){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        else{
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;

        }
        }

        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }

        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }

        Node Mid=getMid(head);
        Node rightHead=Mid.next;
        Mid.next=null;

        Node newleft=mergeSort(head);
        Node newright=mergeSort(rightHead);

        return merge(newleft,newright);
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
        LinkedList2 ll = new LinkedList2();
        ll.addLast(5);
        ll.addLast(3);
        ll.addLast(8);
        ll.addLast(1);
        ll.addLast(6);
        ll.head=ll.mergeSort(ll.head);
        ll.zigZag();
        ll.print();
    }
}

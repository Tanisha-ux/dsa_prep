import java.util.*;
// push--O(n) and pop--O(1)
public class Queueby2Stacks {
    public  static class Queue{
        Stack<Integer>s1=new Stack<>();
        Stack<Integer>s2=new Stack<>();

        public  boolean isEmpty(){
            return s1.isEmpty();
        }

        public   void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public int remove(){
            if(isEmpty()){
                return -1;
            }
            return s1.pop();
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }

            return s1.peek();
        }
    }

    public static void main(String args[]){
        Queue q=new Queue();
        q.add(1);
        q.add(11);
        q.add(111);
        q.add(1111);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }

}

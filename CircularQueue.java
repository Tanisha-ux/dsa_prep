public class CircularQueue{
    public static class Queue{
        int arr[];
        int size;
        int rear;
        int front;

        Queue(int n){
            size=n;
            arr=new int [n];
            front=-1;
            rear=-1;
        }
    

    public boolean isEmpty(){
        return front==-1 && rear==-1;
    }

    public  boolean isFull(){
        return (rear+1)%size==front;
    }

    public  void add(int data){
        if(isFull()){
            System.out.println("full queue");
        }
        if(front==-1){
            front=0;
        }
        rear=(rear+1)%size;
        arr[rear]=data;
    }

    public int remove(){
        int result=arr[0];
        if(isEmpty()){
            System.out.println("empty queue");
            return -1;
        }
        if(front==rear){
            front=rear=-1;
        }
        else{
            front=(front+1)%size;
        }
        return result;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("empty queue");
        }
        return arr[front];
    }
}

    public static void main(String args[]){
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }

}
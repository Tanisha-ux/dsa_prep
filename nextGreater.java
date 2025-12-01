import java.util.*;

public class nextGreater {

    public static void nextgreater(int arr[],int nextGrt[]){
        Stack<Integer> s=new Stack<>();
        for (int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() &&  arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGrt[i]=-1;
            }
            else{
                nextGrt[i]=arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static void print(int nextGrt[]){
        for(int i=0;i<nextGrt.length;i++){
            System.out.println(nextGrt[i]+" ");
        }
         
    }
    
    public static void main(String args[]){
        int arr[]={7,3,5,1,9};
        int nextGrt[]=new int[arr.length];

        nextgreater(arr,nextGrt);
        print(nextGrt);

    }
}

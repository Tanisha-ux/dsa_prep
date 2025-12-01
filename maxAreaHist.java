import java.util.*;
public class maxAreaHist {

    public static int maxArea(int arr[]){
        int maxAr=0;
     
   int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];
        
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);

        }
        
        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=arr.length;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);

        }

        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            maxAr=Math.max(currArea,maxAr);
        }
        return maxAr;


    }
    public static void main(String args[]){
        int arr[]={2,1,5,6,2,3};
        System.out.println(maxArea(arr));

    }
}

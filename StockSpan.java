
import java.util.*;

public class StockSpan{
    
    public static void stockSpanProb(int stocks[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        
        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i]=i+1;
            }
            else{
                span[i]=i-s.peek();

            }
        s.push(i);
        }
        
    }

    public static void print(int sp[]){
        for(int i=0;i<sp.length;i++){
            System.out.print(sp[i]+",");
        }

    }
    public static void main(String args[]){
        
        int stocks[]={100,80,60,70,60,85,100};
        int span[]=new int[stocks.length];
        stockSpanProb(stocks,span);
        print(span);
        
    }
}

import java.util.*;

public class IndianCoins {
    public static void IndCoins(Integer denominations[],int V){
        int TotalVal=V;
        int finalVal=0;
        ArrayList<Integer> ans=new ArrayList<>();
        Arrays.sort(denominations,Comparator.reverseOrder());
         for(int i=0;i<denominations.length;i++){
            if(denominations[i]<=TotalVal){
                while(denominations[i]<=TotalVal){
                    finalVal++;
                    ans.add(denominations[i]);
                    TotalVal-=denominations[i];
                }
                
            }
            
        }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
        System.out.println();
        System.out.println(finalVal);
    }
    public static void main(String args[]){
        int V=121;
        Integer denominations[]={1,2,5,10,20,50,100,500,1000};
        IndCoins(denominations,V);
    }
}

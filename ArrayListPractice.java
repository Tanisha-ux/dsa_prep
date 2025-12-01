import java.util.ArrayList;

public class ArrayListPractice {
    public static int maximumWater(ArrayList<Integer> height){
        int maxWater=0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht=Math.min(height.get(i),height.get(j));
                int width=j-i;

                int currWater=ht*width;
                maxWater=Math.max(currWater,maxWater);
 
            }
            
        }
        return maxWater;
    }

    public static int maximumWater2(ArrayList<Integer> height){
        int maxWater=0;
        int lp=0;
        int rp=height.size()-1;

        while(rp>lp){
            int width=rp-lp;
            int ht=Math.min(height.get(lp),height.get(rp));
            int currWater=ht*width;
            maxWater=Math.max(currWater,maxWater);

            
        }
        return maxWater;

    }

    public static void main(String[] args) {
        ArrayList<Integer> height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(maximumWater(height));
        System.out.println(maximumWater2(height));
    }
}

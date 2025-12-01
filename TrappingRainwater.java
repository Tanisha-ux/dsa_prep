public class TrappingRainwater {
    public static int trappingrainwater(int height[]){
        int n=height.length;
        int leftMaxBound[]=new int[n];
        leftMaxBound[0]=height[0];
        for(int i=1;i<leftMaxBound.length;i++){
            leftMaxBound[i]=Math.max(height[i],leftMaxBound[i-1]);
        }

        int rightMaxBound[]=new int[n];
        rightMaxBound[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMaxBound[i]=Math.max(height[i],rightMaxBound[i+1]);
        }

        int trapWater=0;

        for(int i=0;i<n;i++){
            int waterlevel=Math.min(rightMaxBound[i],leftMaxBound[i]);
            trapWater+=waterlevel-height[i];
        }

        return trapWater;
    }

    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        System.out.println(trappingrainwater(height));
    }
}

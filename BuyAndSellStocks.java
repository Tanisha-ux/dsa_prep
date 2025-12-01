public class BuyAndSellStocks {
    public static int buyAndSellStocks(int prices[]){
        int BP=Integer.MAX_VALUE;
        int maxP=0;

        for(int i=0;i<prices.length;i++){
            if(BP<prices[i]){
                int profit=prices[i]-BP;
                maxP=Math.max(profit,maxP);
            }

            else{
                BP=prices[i];
            }
        }
        return maxP;
    }

    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
        System.out.println(buyAndSellStocks(prices));
    }
}

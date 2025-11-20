package dsa;

public class BuyandSellStock {
    public static void main(String[] args) {
        int[] prices ={100,180,260,310,40,535,695};
        int[] price = {7, 1, 5, 3, 6, 4};
        //Java Program For Stock Buy Sell To Maximize Profit
        //1. One transaction is allowed;
        //2. More than one transaction is allowed

        int maxProfit = maximiseProfit(price);
        System.out.println(maxProfit);
        System.out.println("More than One transaction is allowed");
        int maxProfits = maxProfitWhenMoreThanOneTransaction(price);
        System.out.println(maxProfits);
    }

    /**
     * Code for one transaction is allowed
     * @param prices
     * @return
     */
    private static int maximiseProfit(int[] prices) {
        int minimumprice= prices[0];
        int maxProfit=0;
        int profit=0;
        for(int i=1;i<prices.length; i++){
            if(prices[i]<minimumprice)
                minimumprice= prices[i];

            profit= prices[i]-minimumprice;
            if(profit>maxProfit)
                maxProfit=profit;
        }
        return maxProfit;
    }

    /**
     * Code for more than one transaction is allowed
     * @param prices
     * @return
     */
    private static int maxProfitWhenMoreThanOneTransaction(int[] prices){
        int profit=0;
        for(int i=1; i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit= profit+ prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}

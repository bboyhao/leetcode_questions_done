public class BuySellStockWithCooldown{
    //price is the price of stock on day i
    //buy[i] = max(rest[i-1]-price, buy[i-1])
    //sell[i] = max(buy[i-1]+price, sell[i-1])
    //rest[i] - max(buy[i-1], sell[i-1], rest[i-1])
    //=============================================
    //buy[i]<=rest[i]<=sell[i]
    //==============================================
    //hence, rest[i]=sell[i-1]
    //sub rest[i] == sell[i-1] into the equations
    //buy[i] = max(sell[i-2]-price, buy[i-1])
    //sell[i] = max(buy[i-1]+price, sell[i-1])
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int sell = 0, preSell=0, buy=Integer.MIN_VALUE, preBuy;
        for(int price : prices){
            preBuy = buy;
            buy = Math.max(preSell-price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy+price, preSell);
        }
        return sell;
    }
}

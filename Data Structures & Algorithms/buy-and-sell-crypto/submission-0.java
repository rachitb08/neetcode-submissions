class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int profit = 0;
        int n = prices.length;
        for (int i=0;i<n;i++) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }
            profit = Math.max(profit, prices[i] - minSoFar);
        }    
        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int low =0, high=1;
        while (low < high && high < prices.length) {
            if(prices[low] > prices[high]) {
                low++;
                high = low+1;
            } else {
                maxProfit = Math.max(maxProfit, prices[high] - prices[low]);
                high++;
            }
        }
        return Math.max(maxProfit, 0);
    }
}

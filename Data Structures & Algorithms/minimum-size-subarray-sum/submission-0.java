class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE, L = 0, currentSum = 0;
        for(int R=0; R< nums.length; R++) {
            currentSum = currentSum + nums[R];
            if(currentSum >= target) {
                while(currentSum >= target) {
                    currentSum = currentSum - nums[L];
                    minLength = Math.min(R-L+1, minLength);
                    L++;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }
}
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, r=nums.length-1, maxSum = -1;
        while(l<r) {
            int sum = nums[l] + nums[r];
            if(sum >= k) {
                r--;
            } else {
                l++;
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0, r= k-1;
        List<Integer> maxList = new ArrayList();
        while(r < nums.length) {
            int currentMax = Integer.MIN_VALUE;
            for(int i=l; i <= r; i++) {
                currentMax = Math.max(nums[i], currentMax);
            }
            maxList.add(currentMax);
            l++;
            r++;
        }
        return maxList.stream().mapToInt(i -> i).toArray();
    }
}

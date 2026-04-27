class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int L=0;
        for(int R=0; R< length; R++) {
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[R]) {
                dq.removeLast();
            }
            dq.addLast(R);
            if(L > dq.getFirst()) {
                dq.removeFirst();
            }
            if ((R + 1) >= k) {
                res[L] = nums[dq.getFirst()];
                L++;
            }
        }
        return res;
    }
}

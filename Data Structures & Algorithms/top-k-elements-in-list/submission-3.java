class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int length = nums.length;
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        Map<Integer, Integer> numberToCount = new HashMap();
        for(int num: nums) {
            numberToCount.put(num, numberToCount.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numberToCount.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int res[] = new int[k];
        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll()[1];
        }
        return res;
    }
}

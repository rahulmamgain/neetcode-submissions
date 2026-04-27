class KthLargest {
    int k;
    int[] nums;
    Queue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        pq = new PriorityQueue();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        res.add(intervals[0]);
        for(int[] interval: intervals) {
            int[] lastInterval = res.get(res.size() -1);
            if(interval[0] >= lastInterval[0] && interval[0] <= lastInterval[1]) {
                lastInterval[0] = Math.min(interval[0], lastInterval[0]);
                lastInterval[1] = Math.max(interval[1], lastInterval[1]);
                continue;
            }
            res.add(interval);
        }
        return res.stream().toArray(int[][]::new);
    }
}

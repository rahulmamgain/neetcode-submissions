class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        Queue<Integer> taskQueue = new PriorityQueue<>((a,b) -> b - a);
        for(char task: tasks) {
            counts[task - 'A']++;
        }

        for(int cnt:  counts) {
            if(cnt > 0) {
                taskQueue.offer(cnt);
            }
        }
        int time = 0;
        Queue<int[]> schQueue = new LinkedList<>();
        while(!taskQueue.isEmpty() || !schQueue.isEmpty()){
            time++;

            if(taskQueue.isEmpty()) {
                time = schQueue.peek()[1];
            } else {
                int cnt = taskQueue.poll() - 1;
                if(cnt > 0) {
                    schQueue.offer(new int[]{cnt, time + n});
                }
            }

            while(!schQueue.isEmpty() && schQueue.peek()[1] == time) {
                taskQueue.offer(schQueue.poll()[0]);
            }

        }
        return time;
    }   
}

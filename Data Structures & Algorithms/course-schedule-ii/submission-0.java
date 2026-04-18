class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList();
        int[] output = new int[numCourses];
        for(int i=0; i< numCourses; i++) {
            adj.add(i, new ArrayList());
        }

        for(int[] pre: prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            inDegree[course]++;
            adj.get(prerequisite).add(course);
        }
        Queue<Integer> q = new LinkedList();
        for(int i=0; i< numCourses; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        int outIndex = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            output[outIndex] = course;
            outIndex++;
            for(int nei: adj.get(course)) {
                inDegree[nei] = inDegree[nei] - 1;
                if(inDegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        if(outIndex != numCourses) {
            return new int[0];
        }
        return output;
    }
}

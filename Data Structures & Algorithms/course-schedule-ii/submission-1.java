class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        for(int i=0; i< numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int dependency = prerequisite[1];
            inDegree[course] = inDegree[course]+1;
            adj.get(dependency).add(course);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< numCourses; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int finished = 0;
        int[] output = new int[numCourses];
        while(!q.isEmpty()) {
            int course = q.poll();
            output[finished++] = course;
            for(int nei : adj.get(course)) {
                inDegree[nei] = inDegree[nei] - 1;
                if(inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return finished == numCourses ? output : new int[0];
    }
}

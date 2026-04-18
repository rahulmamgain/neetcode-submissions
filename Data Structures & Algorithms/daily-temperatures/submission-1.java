class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack();
        int res[] = new int[temperatures.length];
        int idx = 0;
        for(int temperature: temperatures) {
            while(!stack.isEmpty() && temperature > stack.peek()[0]) {
                res[stack.peek()[1]] = idx - stack.peek()[1];
                stack.pop();
            }
            stack.push(new int[]{temperature, idx});
            idx++;
        }
        return res;
    }
}

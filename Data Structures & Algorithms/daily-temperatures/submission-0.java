class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int res[] = new int[length];
        for(int i=0; i<length; i++) {
            int days = 0;
            for(int j = i+1; j<length; j++) {
                if(temperatures[j] > temperatures[i]) {
                    days = j-i;
                    break;
                }
            }
            res[i] = days;
        }
        return res;
    }
}

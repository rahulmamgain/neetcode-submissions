class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        for(int i=0; i< length; i++) {
            for(int j=i+1; j< length; j++) {
                int sum = numbers[i] + numbers[j];
                if(sum == target) {
                    return new int[] {i+1, j+1};
                }
            }
        }
        return null;
    }
}

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<Integer>();
        for(int num : nums) {
            if(intSet.contains(num)) {
                return true;
            }
            intSet.add(num);
        }
        return false;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        Set<List<Integer>> resSet = new HashSet();
        for(int i=0; i< length; i++) {
            for(int j=i+1; j<length; j++) {
                for(int k=j+1; k<length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        int[] triplet = new int[] {nums[i], nums[j], nums[k]};
                        Arrays.sort(triplet);
                        List<Integer> tripletList = Arrays.stream(triplet).boxed().toList();
                        if(!resSet.contains(tripletList)) {
                            resSet.add(tripletList);
                            res.add(tripletList);
                        }
                    }
                }
            }
        }
        return res;
    }
}

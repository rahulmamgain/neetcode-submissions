class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, zeroCount = 0;
        int[] res = new int[nums.length];
        for(int num: nums) {
            if(num == 0) {
                zeroCount++;
            } else {
                product = product * num;
            }
        }
        if(zeroCount > 1) {
            return res;
        }

        for(int i=0; i< nums.length; i++) {
            if(zeroCount > 0 && nums[i] == 0){
                res[i] = product;
            } else if(zeroCount > 0) {
                res[i] = 0;
            } else {
                res[i] = product / nums[i];
            }
        }
        return res;
    }
}  

class Solution {
    public int maxArea(int[] heights) {
        int l=0, r=heights.length-1, maxArea = 0;;

        while(l<r) {
            int maxNewArea = Math.min(heights[l], heights[r]) * (r-l);
            if(heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
            maxArea = Math.max(maxArea, maxNewArea);
        }
        return maxArea;
    }
}

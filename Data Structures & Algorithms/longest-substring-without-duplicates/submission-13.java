class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int res = 0, l=0;
        for (int r = 0; r < s.length(); r++) {
            if(lastIndex.containsKey(s.charAt(r))) {
                l = Math.max(lastIndex.get(s.charAt(r)) + 1, l);
            }
            lastIndex.put(s.charAt(r), r);
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}

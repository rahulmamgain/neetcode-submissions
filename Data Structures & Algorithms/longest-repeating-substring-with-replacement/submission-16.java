class Solution {
    public int characterReplacement(String s, int k) {
        char[] charSet = s.toCharArray();
        int L=0, maxLength = 0, maxf = 0;
        HashMap<Character, Integer> charToCountMap = new HashMap<>();

        for(int R=0; R< charSet.length; R++) {
            charToCountMap.put(charSet[R], charToCountMap.getOrDefault(charSet[R], 0) + 1);
            maxf = Math.max(maxf, charToCountMap.get(charSet[R]));
            while((R-L+1) - maxf > k) {
                charToCountMap.put(charSet[L], charToCountMap.get(charSet[L]) - 1);
                L++;
            }
            maxLength = Math.max(maxLength, R-L+1);
        }
        return maxLength;
    }
}

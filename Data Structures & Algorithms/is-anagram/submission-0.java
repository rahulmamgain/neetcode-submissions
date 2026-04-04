

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> stringToCountMap = new HashMap<Character, Integer>();
        for(char sChar: s.toCharArray()) {
            stringToCountMap.merge(sChar, 1, Integer::sum);
        }
        for(char sChar: t.toCharArray()) {
            stringToCountMap.merge(sChar, -1, Integer::sum);
        }
        for(Map.Entry<Character, Integer> entry : stringToCountMap.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}

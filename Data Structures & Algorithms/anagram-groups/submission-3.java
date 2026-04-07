class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedStringToListMap = new HashMap();
        for(String str: strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = new String(strChars);
            sortedStringToListMap.computeIfAbsent(sortedStr, k -> new ArrayList<String>()).add(str);
        }
        return new ArrayList(sortedStringToListMap.values());
    }
}

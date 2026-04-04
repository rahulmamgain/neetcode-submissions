class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedWordToAnagramMap = new HashMap<String, List<String>>();
        for(String str: strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            sortedWordToAnagramMap.computeIfAbsent(new String(strChars), k -> new ArrayList<>()).add(str);
        }
        return sortedWordToAnagramMap.values().stream().collect(Collectors.toList());
    }


}

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = s.length();
        for(int i=0; i<length/2; i++) {
            if(!(s.charAt(i) == s.charAt(length-i-1))) {
                //System.out.println(sChars[i] + " " + sChars[length-i-1]);
                return false;
            }
        }
        return true;
    }
}

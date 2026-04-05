class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] sChars = s.toCharArray();
        int length = sChars.length;
        for(int i=0; i<length/2; i++) {
            if(!(sChars[i] == sChars[length-i-1])) {
                System.out.println(sChars[i] + " " + sChars[length-i-1]);
                return false;
            }
        }
        return true;
    }
}

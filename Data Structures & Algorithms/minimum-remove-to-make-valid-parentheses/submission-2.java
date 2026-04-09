class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch: chars) {
            if(ch == ')' && count <= 0) {
                continue;
            }
            sb.append(ch);
            if(ch == '(') {
                count++;
            } else if(ch == ')') {
                count--;
            }
        }
        StringBuilder filtered = new StringBuilder();
        chars = sb.toString().toCharArray();
        for(int i = chars.length - 1; i >=0 ; i--) {
            if (chars[i] == '(' && count > 0) {
                count--;
            } else {
                filtered.append(chars[i]);
            }
        }
        return filtered.reverse().toString();
    }
}
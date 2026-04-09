class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack();
       for(char sChar: s.toCharArray()) {
            if(stack.isEmpty()) {
                if(sChar == ')' || sChar == '}' || sChar == ']') {
                    return false;
                }
                stack.push(sChar);
                continue;
            }
            char lastChar = stack.peek();
            if(sChar == ')' && lastChar != '(') return false;
            else if(sChar == '}' && lastChar != '{') return false;
            else if(sChar == ']' && lastChar != '[') return false;
            else if(sChar == '(' || sChar == '{' || sChar == '[') stack.push(sChar);
            else stack.pop();
       }
       return stack.isEmpty();
    }
}

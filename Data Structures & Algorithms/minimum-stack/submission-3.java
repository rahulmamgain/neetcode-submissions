class MinStack {

    Stack<Integer> stack;
    int min;

    public MinStack() {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        min = Math.min(val, min);
    }
    
    public void pop() {
        int top = stack.pop();
        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else if (top == min) {
            min = stack.stream().min(Integer::compare).get();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

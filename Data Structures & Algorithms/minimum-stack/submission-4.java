class MinStack {

    Stack<Tuple> stack;

    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int val) {
        int minSoFar = Integer.MAX_VALUE;
        if(!stack.isEmpty()) {
            minSoFar = stack.peek().minSoFar;
        }
        stack.push(new Tuple(val, Math.min(minSoFar, val)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().number;
    }
    
    public int getMin() {
        return stack.peek().minSoFar;
    }

    class Tuple {
        public int number;
        public int minSoFar;
        public Tuple(int number, int minSoFar) {
            this.number = number;
            this.minSoFar = minSoFar;
        }
    }
}

/*
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (30.92%)
 * Total Accepted:    177.2K
 * Total Submissions: 573.3K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 */
import java.lang.Integer;

class MinStack {

    /** initialize your data structure here. */
    private int[] a = null;
    private int n = 0;
    private int minValue = Integer.MAX_VALUE;
    public MinStack() {
        n = 0;
        a = new int[1];
    }
    
    private void resize(int size){
    	int[] b = new int[size];
    	for(int i = 0; i < n; i++)
    		b[i] = a[i];
    	a = b;
    }

    public void push(int x) {
        if(n == a.length)
        	resize(2*n);
        a[n++] = x;
        if(x < minValue)
        	minValue = x;
    }

    public void pop() {
    	if(n == 0)
    		throw new RuntimeException("The stack is empty!");
    	n--;
    	if(minValue == a[n])
    		minValue = min();
    	if(n > 0 && n == a.length / 4)  // n > 0 && n == a.length / 4
    		resize(a.length / 2);
    }

    private int min(){
    	int value = Integer.MAX_VALUE;
    	for(int i = 0; i < n; i++){
    		if(a[i] < value)
    			value = a[i];
    	}
    	return value;
    }
    
    public int top() {
        if(n == 0)
        	throw new RuntimeException("The stack is empty!");
        return a[n - 1];
    }
    
    public int getMin() {
        if(n == 0)
        	throw new RuntimeException("The stack is empty!");
        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

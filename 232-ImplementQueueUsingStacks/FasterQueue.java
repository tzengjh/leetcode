import java.util.Stack;

class FasterQueue {

	private int front;
	private Stack<Integer> dequeStack;
	private Stack<Integer> enqueStack;
	/** Initialize your data structure here. */
	public FasterQueue() {
		dequeStack = new Stack<>();
		enqueStack = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if(enqueStack.isEmpty())
			front = x;
		enqueStack.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if(dequeStack.isEmpty()){
			while(!enqueStack.isEmpty())
				dequeStack.push(enqueStack.pop());
		}
		if(dequeStack.isEmpty())
			throw new UnsupportedOperationException("Pop operation is not supported in an empty queue!");
		return dequeStack.pop();
	}

	/** Get the front element. */
	public int peek() {
		if(dequeStack.isEmpty() && !enqueStack.isEmpty()){
			return front;
		}else{
			return dequeStack.peek();
		}
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return enqueStack.isEmpty() && dequeStack.isEmpty();
	}

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

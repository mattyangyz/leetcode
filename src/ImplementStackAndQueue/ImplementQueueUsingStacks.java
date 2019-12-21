package ImplementStackAndQueue;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * <p>
 * 思路: 在push的时候花点心思，然后其他的operations的话就按照正常的来。
 */

public class ImplementQueueUsingStacks {

    Stack<Integer> value;
    Stack<Integer> temp;

    public ImplementQueueUsingStacks() {
        value = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        if (value.isEmpty()) {
            value.push(x);
        } else {
            while (!value.isEmpty()) {
                temp.push(value.pop());
            }
            value.push(x);              // 新的element必须放在value的底部， 最后才pop出来
            while (!temp.isEmpty()) {
                value.push(temp.pop());
            }
        }
    }

    public int pop() {
        return value.pop();
    }

    public int peek() {
        return value.peek();
    }

    public boolean empty() {
        return value.isEmpty();
    }
}

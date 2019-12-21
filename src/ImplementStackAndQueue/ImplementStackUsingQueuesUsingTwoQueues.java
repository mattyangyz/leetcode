package ImplementStackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueuesUsingTwoQueues {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public ImplementStackUsingQueuesUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
            for (int i = 0; i < queue2.size(); i++) {
                queue1.offer(queue2.poll());
            }
        } else {
            queue2.add(x);
            for (int i = 0; i < queue1.size(); i++) {
                queue2.offer(queue1.poll());
            }
        }
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            return queue1.poll();
        } else {
            return queue2.poll();
        }
    }

    public int top() {
        return queue1.isEmpty() ? queue2.peek() : queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

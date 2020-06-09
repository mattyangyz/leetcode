package Design;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * mplement a thread safe bounded blocking queue that has the following methods:
 * <p>
 * BoundedBlockingQueue(int capacity) The constructor initializes the queue with a maximum capacity.
 * void enqueue(int element) Adds an element to the front of the queue. If the queue is full, the calling thread is blocked until the queue is no longer full.
 * int dequeue() Returns the element at the rear of the queue and removes it. If the queue is empty, the calling thread is blocked until the queue is no longer empty.
 * int size() Returns the number of elements currently in the queue.
 * Your implementation will be tested using multiple threads at the same time. Each thread will either be a producer thread that only makes calls to the enqueue method or a consumer thread that only makes calls to the dequeue method. The size method will be called after every test case.
 * <p>
 * Please do not use built-in implementations of bounded blocking queue as this will not be accepted in an interview.
 * <p>
 * 思路: 要弄懂怎么yongreentrantLock。
 * <p>
 * 2020 Jun 8
 */


public class BoundedBlockingQueue {

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    private ArrayList<Integer> list;
    private int size;

    public BoundedBlockingQueue(int capacity) {
        this.size = capacity;
        list = new ArrayList<>(capacity);
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();

        try {
            while (size == list.size()) {
                full.await();
            }

            list.add(0, element);
            size++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();

        try {
            while (list.size() == 0) {
                empty.await();
            }
            int res = list.remove(list.size() - 1);
            size--;
            full.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        try {
            lock.lock();
            return list.size();
        } finally {
            lock.unlock();
        }
    }
}
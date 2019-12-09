package Design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    private Queue<Integer> queue;
    private double sum = 0;
    private int size;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.remove();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }
}

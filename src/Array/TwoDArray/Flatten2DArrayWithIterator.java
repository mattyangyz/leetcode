package Array.TwoDArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flatten2DArrayWithIterator {

    Iterator<List<Integer>> itrs;           // 存list
    Iterator<Integer> row;                  // 存list 里面的 integer

    public Flatten2DArrayWithIterator(int[][] arrays) {

        List<List<Integer>> vec2d = new ArrayList<>();
        if (vec2d == null || vec2d.size() == 0) {
            return;
        }
        itrs = vec2d.iterator();
        row = itrs.next().iterator();
        getNextRow();                       // make sure point to non empty list
    }

    private void getNextRow() {
        while (!row.hasNext() && itrs.hasNext()) {
            row = itrs.next().iterator();
        }
    }

    public int next() {
        int next = row.next();
        getNextRow();
        return next;
    }

    public boolean hasNext() {
        return row != null && row.hasNext();
    }
}

package Iterator;

import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * <p>
 * Example:
 * <p>
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * <p>
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * <p>
 * How would you extend your design to be generic and work with all types, not just integer?
 *
 * 思路: 用一个var 把下一个element cache起来call next的时候就return这个next。并且把当前next挪到下一个element那里去。
 */

// ini一个iterator和一个next的variable，去cache这个next的element，在constructor的时候直接init
// next, 然后peek的时候直接返回，然后next的时候也是返回这个next，但记得要更新到下一个元素
public class PeekingIterator<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private T next;

    public PeekingIterator(Iterator<T> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = null;
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        T res = next;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = null;
        }
        return res;

    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}

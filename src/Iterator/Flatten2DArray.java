package Iterator;


/**
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * <p>
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 * <p>
 * <p>
 * 这题的关键在于让hasNext去move cross array，让next去移动到一下个element
 * 如果现在已经到达subarray的最后一个elemnt1的，hasNext就去移动到下一个。
 */

public class Flatten2DArray {

    int arrayIndex;
    int elementIndex;
    int[][] array;

    public Flatten2DArray(int[][] v) {
        arrayIndex = 0;
        elementIndex = 0;
        array = v;
    }

    public int next() {
        if (hasNext()) {          // 一定要call hasNext，若已经是此subarray里面最后一个element了的话，就要移动到下一个subarray。
            return array[arrayIndex][elementIndex++];
        }
        return -1;
    }

    public boolean hasNext() {
        if (array.length != 0) {

            // 还没到最后一排 但是已经超过最后一个element了。
            while (arrayIndex < array.length - 1 && elementIndex == array[arrayIndex].length) { //这里一定得是 - 1
                arrayIndex++;
                elementIndex = 0;
            }
            // 如果到达最后一排了，直接看是不是超过最后一个element就行了
            return elementIndex < array[arrayIndex].length;
        } else {
            return false;
        }
    }
}

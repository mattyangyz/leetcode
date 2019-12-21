package Array.TwoDArray;

public class Flatten2DArray {

    int indexArray = 0;
    int indexElement = 0;
    int[][] vector;

    public Flatten2DArray(int[][] v) {
        vector = v;
    }

    public int next() {
        if (hasNext()) {
            return vector[indexArray][indexElement++];
        } else {
            return -1;
        }
    }

    public boolean hasNext() {
        while (indexArray < vector.length && indexElement == vector[indexElement].length) {
            indexArray++;
            indexElement = 0;
        }
        return indexArray < vector.length;
    }
}

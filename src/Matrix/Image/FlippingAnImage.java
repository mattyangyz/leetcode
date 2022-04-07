package Matrix.Image;

public class FlippingAnImage {

    // 最优解是通过一个loop去完成，而不是两个。
    public int[][] flipAndInvertImage(int[][] image) {
        int C = image.length;
        for(int[] row: image){
            for(int i = 0; i < (C + 1) / 2; i++){
                int temp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - i - 1] = temp;
            }
        }

        return image;
    }
}

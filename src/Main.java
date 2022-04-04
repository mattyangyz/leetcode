import java.util.ArrayList;
import java.util.Optional;

public class Main {

    public static void main(String args[]) {

        final var entry = new Entry(1, 2);


        int[] array = new int[2];
        System.out.println(array.getClass());


        Optional.ofNullable(entry).
                map( o -> o.getNext()).orElseGet(() -> {
                    System.out.println("check");
                    return null;
                }
                    );

        final var arrays = new ArrayList<>();
        final var array1 = new ArrayList<>();
        array1.add(1);
        array1.add(2);

        final var array2 = new ArrayList<>();
        array2.add(1);
        array2.add(1);
        array2.add(1);

        arrays.add(array1);
        arrays.add(array2);


        for (int i = 0; i < array1.size(); i++) {
            for (int j = i + 1; j < array1.size() - 1; j++) {
                for(int k = j + 1; k < array1.size() - 2; k++){

                }
            }
        }

    }

    static class Entry {
        Integer key;
        int value;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getNext(){
            return null;
        }


    }

}

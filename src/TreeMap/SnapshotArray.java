package TreeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapshotArray {

     private List<TreeMap<Integer, Integer>> map;
     private int snapId;

    public SnapshotArray(int length) {
        map = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            map.add(new TreeMap<>());
            map.get(i).put(0, 0);
        }
        snapId = 0;
    }

    public void set(int index, int val){
        map.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId){
        return map.get(index).floorEntry(snapId).getValue();
    }
}

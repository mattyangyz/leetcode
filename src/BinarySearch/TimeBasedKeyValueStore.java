package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create a timebased key-value store class TimeMap, that supports two operations.
 * <p>
 * 1. set(string key, string value, int timestamp)
 * <p>
 * Stores the key and value, along with the given timestamp.
 * 2. get(string key, int timestamp)
 * <p>
 * Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the one with the largest timestamp_prev.
 * If there are no values, it returns the empty string ("").
 * <p>
 * <p>
 * <p>
 * 思路: 这题的难点在于在get的时候要找到比timestamp小的最大的数，也就是第一个比timestamp的数。
 * https://www.youtube.com/watch?v=6GZpH-ygMEs&t=96s
 */

public class TimeBasedKeyValueStore {

    class Data {
        String val;
        int time;

        public Data(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    Map<String, List<Data>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        return binarySearch(map.get(key), timestamp);
    }


    // 这是一个特别的binarySearch， 需要找出比timeStamp小的最大那个数。
    private String binarySearch(List<Data> data, int timeStamp) {

        int low = 0;
        int high = data.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (data.get(mid).time == timeStamp) {
                return data.get(mid).val;
            }

            if (timeStamp > data.get(mid).time) {
                if (data.get(mid + 1).time > timeStamp) {
                    return data.get(mid).val;
                }
                low = mid + 1;

            } else if (timeStamp < data.get(mid).time) {
                high = mid - 1;
            }
        }
        return data.get(low).time > timeStamp ? "" : data.get(low).val;
    }
}
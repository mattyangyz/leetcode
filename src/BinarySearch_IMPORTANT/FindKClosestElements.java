//package BinarySearch;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FindKClosestElements  {
//
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> res = new ArrayList<>();
//        int begin = 0;
//        int end = arr.length - k;
//
//        while (begin < end) {
//            int mid = begin + (end - begin) / 2;
//            if (x > arr[mid]) {                 // x的左区间有可能在mid的左边或右边
//
//                if (x - arr[mid] > arr[mid + k] - x) {    // 这里是重点 难！！！！！！！！！！！！！！！1
//
//                }
//            }
//        }
//    }
//}
//
//
//
//
// 非常难， 两天了 难在17行那里

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String args[]) {

//        int result = BestTimeToBuyAndSellStockII.maxProfit(new int[]{7,1,5,3,6,4});
//        System.out.println(result);

//        MinimumWindowSubstring.minWindow("ADZABC", "ABC");

        String first = new String("0:start:0");
        String second = new String("1:start:2");
        String third = new String("1:end:5");
        String fourth = new String("0:end:6");
//        String fifty = new String("0:end:5");

        List<String> array = new ArrayList<>();
        array.add(first);
        array.add(second);
        array.add(third);
        array.add(fourth);
//        array.add(fifty);


//        List<ListNode> nodes1 =  new ArrayList<>();
//
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(15);
//        ListNode node3 = new ListNode(20);
//        ListNode node4 = new ListNode(30);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//        List<ListNode> nodes2 =  new ArrayList<>();
//
//        ListNode node10 = new ListNode(2);
//        ListNode node11 = new ListNode(22);
//        ListNode node12 = new ListNode(35);
//        ListNode node13 = new ListNode(40);
//        node10.next = node11;
//        node11.next = node12;
//        node12.next = node13;
//
//        List<ListNode> nodes3 =  new ArrayList<>();
//
//        ListNode node30 = new ListNode(5);
//        ListNode node31 = new ListNode(10);
//        ListNode node32 = new ListNode(15);
//        ListNode node33 = new ListNode(90);
//        node30.next = node31;
//        node31.next = node32;s
//        node32.next = node33;
//
//        ListNode[] arr = new ListNode[3];ß
//        arr[0] = node1;
//        arr[1] = node10;
//        arr[2] = node30;
//
//        MergeKSortedLists.mergeKListWithPriorityQueue(arr);

//        SqrtX.mySqrt(8);


//        DesignHitCounterWithLargeHitsPerSec count = new DesignHitCounterWithLargeHitsPerSec();
//        count.hit(2);
//        count.hit(2);
//        count.hit(2);
//        count.getHits(303);

//        TopKFrequentElement.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);

        //MissingElementInSortedArray.missingElement(new int[]{2,3,5,7}, 1);
//        SqrtX.mySqrt(26);
//        TaskScheduler.leastInterval(new char[]{'A','B','A','B'}, 2);

//        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
//        queue.offer(3);
//        queue.offer(2);
//        queue.offer(1);
//        queue.offer(0);
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());

        Comparator<String> cp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };

        String[] sts = new String[]{"3", "30"};
        Arrays.sort(sts, cp);
        System.out.println(sts[0]);
    }
}

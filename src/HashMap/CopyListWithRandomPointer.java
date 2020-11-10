package HashMap;


import java.util.HashMap;
import java.util.Map;

// 这题的难点在于遇到下一个random的时候怎么确保new出来的哪一个跟遇到真正curr为random的时候是一样的。
// 这就需要分两次遍历，第一次先把所有的node给new了 放到一个map里面。然后在第二次遍历的时候直接从map中去去assign给next和random。
public class CopyListWithRandomPointer {


    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr1 = head;
        while (curr1 != null) {
            map.put(curr1, new Node(curr1.val, null, null));
            curr1 = curr1.next;
        }

        Node curr2 = head;
        while (curr2 != null) {
            Node temp = map.get(curr2);
            temp.next = map.get(curr2.next);
            temp.random = map.get(curr2.random);
            curr2 = curr2.next;
        }

        return map.get(head);
    }


    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}


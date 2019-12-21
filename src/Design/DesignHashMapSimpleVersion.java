package Design;

public class DesignHashMapSimpleVersion {

    private static class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    ListNode[] nodes;

    public DesignHashMapSimpleVersion() {
        nodes = new ListNode[10000];
    }

    public void put(int key, int value) {
        int index = hashing(key);
        if (nodes[index] == null) {
            nodes[index] = new ListNode(-1, -1);
        }
        ListNode prev = find(nodes[index], key);    // see if key exist in the list
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;                  // overwrite the current key-value with the new value
        }
    }

    public int get(int key) {
        int index = hashing(key);
        if (nodes[index] == null) {
            return -1;
        }
        ListNode node = find(nodes[index], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {
        int index = hashing(key);
        if (nodes[index] == null) {
            return;
        }
        ListNode prev = find(nodes[index], key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;             // delete that node from the list
        }

    }

    private int hashing(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    ListNode find(ListNode bucket, int key) {       // always return a node before that
        ListNode node = bucket;
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

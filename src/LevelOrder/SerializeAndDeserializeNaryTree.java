package LevelOrder;

import java.util.*;

public class SerializeAndDeserializeNaryTree {

    public String serialize(Node root) {
        List<String> list = new LinkedList<>();
        sHelper(root, list);
        return String.join(",", list);
    }

    private void sHelper(Node root, List<String> list) {
        if (root == null) {
            return;
        }
        list.add(String.valueOf(root.val));
        list.add(String.valueOf(root.children.size()));
        for (Node child : root.children) {
            sHelper(child, list);
        }
    }


    public Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] s = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(s));
        return dHelper(queue);
    }

    private Node dHelper(Queue<String> queue) {
        Node root = new Node();
        root.val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());
        root.children = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            root.children.add(dHelper(queue));
        }
        return root;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}



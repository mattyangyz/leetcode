package Graph;

import java.util.*;

/**
 * Linkedin
 * <p>
 * Given a reference of a node in a connected undirected graph,
 * return a deep copy (clone) of the graph. Each node in the graph
 * contains a val (int) and a list (List[Node]) of its neighbors.
 * <p>
 * Example:
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},
 * {"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * <p>
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes will be between 1 and 100.
 * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * You must return the copy of the given node as a reference to the cloned graph.
 * <p>
 * Connected Undirected Graph can be represented like this:
 * <p>
 * https://stackoverflow.com/questions/41291736/the-connected-components-in-an-undirected-graph-of-a-given-amount-of-vertices-a?rq=1
 */

public class CloneGraph {

    HashMap<Node, Node> originalCloneMap = new HashMap();

    // DFS
    public Node cloneGraph(Node node) {
        return dfsHelper(node);
    }

    private Node dfsHelper(Node node) {
        if (node == null) {
            return null;
        }

        if (originalCloneMap.containsKey(node)) {  //已经复制过了， 不需要再对其neighbor进行遍历的 否则会导致死循环
            return originalCloneMap.get(node);     //这里要保证必须返回一个 新的visited node， 不能直接返回 return node
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        originalCloneMap.put(node, cloneNode);     //这里关键是放进去原本的node作为key，新的cloneNode作为value

        for (Node neighbor : node.neighbors) {
            neighbor = dfsHelper(neighbor);
            cloneNode.neighbors.add(neighbor);
        }
        return cloneNode;
    }

    // BFS
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }

        List<Node> nodes = getNodes(node);
        Map<Node, Node> map = new HashMap<>();  // 用来记录原本nodes跟新nodes的一一对应关系
        for (Node curr : nodes) {
            map.put(curr, new Node(curr.val, new ArrayList<>()));
        }

        for (Node curr : nodes) {
            Node currClone = map.get(curr);
            for (Node neighbor : curr.neighbors) {
                currClone.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);


    }

    public List<Node> getNodes(Node node) {         // 拿到所有nodes先

        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> nodes = new HashSet<>();

        queue.offer(node);
        nodes.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {
                if (!nodes.contains(neighbor)) {
                    queue.offer(neighbor);
                    nodes.add(neighbor);
                }
            }
        }
        return new ArrayList<>(nodes);
    }
}

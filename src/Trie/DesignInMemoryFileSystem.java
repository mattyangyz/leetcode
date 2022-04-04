package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 这一题是根据这里来的 https://www.youtube.com/watch?v=Bi58kAbTEjw
public class DesignInMemoryFileSystem {

    public static void main(String[] args){
        DesignInMemoryFileSystem fileSystem = new DesignInMemoryFileSystem();
        fileSystem.ls("/");
        fileSystem.mkdir("/a/b/c/");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        fileSystem.ls("/");
    }

    class Node {
        String name;
        boolean isFile;
        StringBuilder content;
        HashMap<String, Node> children;

        public Node(String name){
            this.name = name;
            content = new StringBuilder();
            children = new HashMap<>();
        }
    }

    Node root;

    public DesignInMemoryFileSystem() {
        root = new Node("/");
    }

    private Node traverse(String filePath){
        String[] path = filePath.split("/");
        Node curr = root;
        for(int i = 1; i < path.length; i++){
            if(!curr.children.containsKey(path[i])){
                Node node = new Node(path[i]);
                curr.children.put(path[i], node);
            }
            curr = curr.children.get(path[i]);
        }
        return curr;
    }

    public List<String> ls(String path) {
        Node node = traverse(path);
        List<String> res = new ArrayList<>();
        if (!node.isFile) {
            for (String children : node.children.keySet()) {
                res.add(children);
            }
        }else{
            res.add(node.name);
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        Node node = traverse(filePath);
        return node.content.toString();
    }
}

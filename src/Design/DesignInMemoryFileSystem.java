//package Design;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class DesignInMemoryFileSystem {
//
//    Node root;
//
//    public DesignInMemoryFileSystem() {
//        root = new Node("/");
//    }
//
//    public List<String> ls(String path) {
//
//    }
//
//    public void mkdir(String path) {
//
//    }
//
//    public void addContentToFile(String filePath, String content) {
//
//    }
//
//    public String readContentFromFile(String filePath) {
//
//    }
//
//    private Node traverse(String filePath){
//        String[] paths = filePath.split("/");
//
//        Node curr = root;
//        for (int i = 1; i < paths.length; i++) {  // 第一个是 " "， 所以从一开始
//             cur = curr
//        }
//    }
//
//    class Node{
//        String name;
//        boolean isFile;
//        StringBuilder content;
//        HashMap<String, Node> children;
//
//        public Node(String name) {
//            this.name = name;
//            isFile = false;
//            content = new StringBuilder();
//            children = new HashMap<>();
//        }
//    }
//}

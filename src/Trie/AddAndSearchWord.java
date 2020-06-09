package Trie;

/**
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */

// 数据结构就是典型的trie，addword跟trie的一模一样。然后find使用recursive去找

public class AddAndSearchWord {

    class TrieNode {                                 // 每一个node就是一个char 加上一个size 26的children TrieNode
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
            val = ' ';
            isWord = false;
        }
    }

    private TrieNode root;

    public AddAndSearchWord() {
        root = new TrieNode();
    }

    public void addWord(String word) {                         // 这个方法跟implementTrie的一样
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (cur.children[c - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                newNode.val = c;
                cur.children[c - 'a'] = newNode;
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }


    public boolean search(String word) {
        return find(word, root, 0);
    }

    public boolean find(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isWord;                                            //必须是.isWord， 以防apple，存进来appl这种情况
        }
        if (word.charAt(index) == '.') {
            for (TrieNode temp : node.children) {
                if (temp != null && find(word, temp, index + 1)) {    // 只要是有孩子就行，因为是 '.'
                    return true;
                }
            }
            return false;
        } else {
            int j = word.charAt(index) - 'a';
            TrieNode temp = node.children[j];
            return temp != null && find(word, temp, index + 1);
        }
    }


}

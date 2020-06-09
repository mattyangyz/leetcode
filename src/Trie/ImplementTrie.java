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

public class ImplementTrie {

    class TrieNode {                                 // 每一个node就是一个char 加上一个size 26的children TrieNode
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
            val = ' ';
            isWord = false;
        }
    }

    public class Trie {
        private TrieNode root;                      // 有一个root

        public Trie() {
            root = new TrieNode();
            root.val = ' ';
        }

        public void insert(String word) {

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
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }

}

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

    AddAndSearchWord.TrieNode root;

    public ImplementTrie() {
        root = new AddAndSearchWord.TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        AddAndSearchWord.TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                AddAndSearchWord.TrieNode child = new AddAndSearchWord.TrieNode();
                node.children[j] = child;
            }
            node = node.children[j];
        }
        node.isWord = true;
        node.word = word;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {

        AddAndSearchWord.TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                return false;
            }
            node = node.children[j];
        }
        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        AddAndSearchWord.TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (node.children[j] == null) {
                return false;
            }
            node = node.children[j];
        }
        return true;
    }
}

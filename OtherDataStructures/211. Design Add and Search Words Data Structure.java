class WordDictionary {
    private WordDictionary[] children;
    boolean isEndOfWord;

    // Initialize your data structure here.
    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord = false;
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        WordDictionary curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new WordDictionary();
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    // Returns if the word is in the data structure. A word could contain the dot
    // character '.' to represent any one letter.
    public boolean search(String word) {
        WordDictionary curr = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                for (WordDictionary ch : curr.children)
                    if (ch != null && ch.search(word.substring(i + 1)))
                        return true;
                return false;
            }
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return curr != null && curr.isEndOfWord;
    }
}

/**
 * class WordDictionary {
 * Trie trie;
 * public WordDictionary() {
 * this.trie = new Trie();
 * }
 * 
 * public void addWord(String word) {
 * trie.add(word);
 * }
 * 
 * public boolean search(String word) {
 * return trie.search(word);
 * }
 * }
 * 
 * class Trie {
 * Trie[] children;
 * boolean isWord;
 * Trie() {
 * this.children = new Trie[26];
 * }
 * 
 * public void add(String word) {
 * Trie curr = this;
 * for (char c : word.toCharArray()) {
 * if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Trie();
 * curr = curr.children[c - 'a'];
 * }
 * curr.isWord = true;
 * }
 * 
 * public boolean search(String word) {
 * return search(this, word, 0);
 * }
 * 
 * private boolean search(Trie curr, String word, int idx) {
 * if (idx == word.length()) return curr.isWord;
 * 
 * char c = word.charAt(idx);
 * if (c != '.')
 * return curr.children[c - 'a'] != null && search(curr.children[c - 'a'], word,
 * idx + 1);
 * 
 * for (int i = 0; i < 26; i++) {
 * if (curr.children[i] != null) {
 * if(search(curr.children[i], word, idx + 1)) return true;
 * }
 * }
 * return false;
 * }
 * }
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
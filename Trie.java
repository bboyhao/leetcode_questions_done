public class Trie{
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!cur.containsKey(ch)){
                cur.put(ch, new TrieNode());
            }
            cur = cur.get(ch);
        }
        cur.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i<word.length();i++){
            char ch = word.charAt(i);
            if(!cur.containsKey(ch)){
                return false;
            }
            cur = cur.get(ch);
        }
        return cur!=null && cur.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!cur.containsKey(ch)){
                return false;
            }
            cur = cur.get(ch);
        }
        return cur != null;

    }

    private class TrieNode{
        private final int R = 26;
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode(){
            this.links = new TrieNode[R];
        }

        public boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }

        public TrieNode get(char ch){
            return links[ch-'a'];
        }

        public void put(char ch, TrieNode n){
            links[ch-'a'] = n;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }
}

class SolutionA {
    public String solution(String[] participant, String[] completion) {
        Trie root = new Trie();
        for (String c : completion) {
            root.insert(c, 0);
        }
        for (String p : participant) {
            if (!root.search(p)) {
                return p;
            }
        }
        
        return "";
    }
}

class Trie {
    private int count = 0;
    private Trie[] children = new Trie[26];
    
    public void insert(String participant, int index) {
        int childIndex = parseCharToIndex(participant.charAt(index));
        if (children[childIndex] == null) {
            children[childIndex] = new Trie();
        }
        Trie next = children[childIndex];
        if (participant.length() == index + 1) {
            next.count++;
        } else {
            next.insert(participant, index + 1);
        }
    }
    
    public boolean search(String participant) {
        Trie cursor = this;
        for (char c : participant.toCharArray()) {
            int index = parseCharToIndex(c);
            if (cursor.children[index] == null) {
                return false;
            }
            cursor = cursor.children[index];
        }
        if (cursor.count > 0) {
            cursor.count--;
            return true;
        } else {
            return false;
        }
    }
    
    private int parseCharToIndex(char c) {
        return c - 'a';
    }
}
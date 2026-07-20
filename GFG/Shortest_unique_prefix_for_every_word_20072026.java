package GFG;

// tc - O(n*m + nm), sc - O(n * m)
class Solution {
    class TrieNode {
        int count;
        TrieNode[] child;

        public TrieNode(int count) {
            this.count = count;
            child = new TrieNode[26];
        }
    }

    public TrieNode insert(int i, String s, TrieNode root) {
        if(root == null) root = new TrieNode(0);
        root.count++;

        if(i == s.length()) return root;

        int idx = s.charAt(i) - 'a';

        root.child[idx] = insert(i+1, s, root.child[idx]);

        return root;
    }

    private TrieNode buildTrie(ArrayList<String> arr) {
        TrieNode root = new TrieNode(0);

        for(String str : arr) {
            insert(0, str, root);
        }
        return root;
    }

    private String getUniquePrefix(int i, StringBuilder sb, String str, TrieNode root) {
        if(root == null || i == str.length()) return sb.toString();
        if(root.count == 1) return sb.toString();

        char ch = str.charAt(i);
        sb.append(ch);

        return getUniquePrefix(i+1, sb, str, root.child[(int)(ch-'a')]);
    }


    public ArrayList<String> findPrefixes(ArrayList<String> arr) {
        int n = arr.size();

        if(n == 1) {
            return new ArrayList<String>(List.of("" + arr.get(0).charAt(0)));
        }

        TrieNode root = buildTrie(arr);
        ArrayList<String> result = new ArrayList<>();

        for(String str : arr) {
            String curr = getUniquePrefix(0, new StringBuilder(), str, root);
            result.add(curr);
        }
        return result;
    }
}

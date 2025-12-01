package GFG;

// tc - O(b), sc - O(n log(max))
class Solution {
    static class Trie {
        Trie[] next = new Trie[2];
        int count = 0;
    }

    Trie root = new Trie();

    private void insert(int num) {
        Trie node = root;
        for (int b = 31; b >= 0; b--) {
            int bit = (num >> b) & 1;
            if (node.next[bit] == null) node.next[bit] = new Trie();
            node = node.next[bit];
            node.count++;
        }
    }

    private int countLess(int x, int k) {
        Trie node = root;
        int total = 0;

        for (int b = 31; b >= 0; b--) {
            if (node == null) break;

            int xb = (x >> b) & 1;
            int kb = (k >> b) & 1;

            if (kb == 1) {
                if (node.next[xb] != null) total += node.next[xb].count;
                node = node.next[xb ^ 1];
            }
            else node = node.next[xb];
        }

        return total;
    }

    public int cntPairs(int[] arr, int k) {
        int count = 0;

        for (int x : arr) {
            count += countLess(x, k);

            insert(x);
        }

        return count;
    }
}

package GFG;

/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

// tc - O(n), sc - o(n) - call stack
class Solution {
    public int minDiff(Node root, int k) {
        if(root == null) return Integer.MAX_VALUE;

        int curr = Math.abs(root.data - k);

        if(root.data == k) return 0;

        if(root.data < k) return Math.min(curr, minDiff(root.right, k));

        return Math.min(curr, minDiff(root.left, k));
    }
}
package GFG;


// tc - O(n), sc - O(n)
class Solution {
    private int helper(Node root, int max) {
        if(root == null) return Integer.MIN_VALUE;

        int diff1 = helper(root.left, Math.max(max, root.data));
        int diff2 = helper(root.right, Math.max(max, root.data));

        return Math.max(max - root.data, Math.max(diff1 ,diff2));
    }

    int maxDiff(Node root) {
        return Math.max(helper(root.left, root.data), helper(root.right, root.data));
    }
}

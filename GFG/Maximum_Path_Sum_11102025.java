package GFG;

// o(n) visited all node and stack space
class Solution {
    int max;
    private int helper(Node root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max, left + right + root.data);
        return Math.max(0, Math.max(left, right)+root.data);

    }
    int findMaxSum(Node root) {
        max = root.data;
        helper(root);
        return max;
    }
}
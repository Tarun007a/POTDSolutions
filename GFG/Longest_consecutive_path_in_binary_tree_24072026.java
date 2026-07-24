package GFG;

// tc & sc - O(n)
class Solution {
    private int helper(int prev, int size, Node root) {
        if(root == null) return -1;

        int curr = 0;
        if(root.data == prev+1) curr = size+1;

        return Math.max(curr, Math.max(helper(root.data, curr, root.left),
                helper(root.data, curr, root.right)));
    }

    public int longestConsecutive(Node root) {
        int result = helper(-1, 0, root);
        if(result == 0) return -1;
        return result + 1;
    }
}

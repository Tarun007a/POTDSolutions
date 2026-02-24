package Leetcode;

// leetcode - 1022
// tc - O(n), sc - o(n)
class Solution {
    private int getTotal(int value, TreeNode root){
        int curr = value*2 + root.val;
        if(root.left != null && root.right != null)return getTotal(curr, root.left) + getTotal(curr, root.right);
        if(root.left != null) return getTotal(curr, root.left);
        if(root.right != null) return  getTotal(curr, root.right);
        return curr;
    }
    public int sumRootToLeaf(TreeNode root) {
        return getTotal(0, root);
    }
}
package Leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// leetcode - 1161
// tc - O(n), sc - O(n)
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int max = root.val;
        int result = 1;
        int lvl = 1;

        while(!q.isEmpty()){
            int size = q.size();
            int curr = 0;

            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                curr += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(curr > max){
                max = curr;
                result = lvl;
            }
            lvl++;
        }
        return result;
    }
}

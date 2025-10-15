package GFG;


class Solution {
    public int helper(Node root, int[] k){
        if(root == null) return -1;

        int left = helper(root.left, k);
        if(left != -1) return left;

        k[0]--;
        if(k[0] == 0) return root.data;

        int right = helper(root.right, k);
        return right;
    }
    public int kthSmallest(Node root, int k) {
        return helper(root, new int[]{k});
    }
}

package Leetcode;

// leetcode - 1382
// tc - O(n), sc - O(1)
class Solution {
    private void inOrder(TreeNode root, List<TreeNode> tree){
        if(root == null)return;
        inOrder(root.left, tree);
        tree.add(root);
        inOrder(root.right, tree);;
    }
    public TreeNode createTree(List<TreeNode> tree, int lo, int hi){
        if(lo > hi)return null;
        int mid = lo-(lo-hi)/2;
        TreeNode root = tree.get(mid);
        root.left = createTree(tree, lo, mid-1);
        root.right = createTree(tree, mid+1, hi);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> tree = new ArrayList<>();
        inOrder(root, tree);
        return createTree(tree, 0, tree.size()-1);
    }
}
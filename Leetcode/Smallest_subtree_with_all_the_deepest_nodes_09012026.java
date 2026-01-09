package Leetcode;


// leetcode - 865
// tc - O(n^3), sc - (n)
class Solution {
    private boolean isPresent(TreeNode root, int val){
        if(root == null) return false;

        if(root.val == val) return true;
        return isPresent(root.left, val) || isPresent(root.right, val);
    }

    private TreeNode lca(TreeNode root, int val1, int val2){
        if(root.val == val1 || root.val == val2) return root;

        boolean left1 = isPresent(root.left, val1);
        boolean left2 = isPresent(root.left, val2);

        if(left1 && left2) return lca(root.left, val1, val2);
        if((left1 || left2)) return root;
        return lca(root.right, val1, val2);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ArrayList<Integer> lastLevel = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode result = root;

        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                currLevel.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            lastLevel = currLevel;
        }

        if(lastLevel.size() == 1) return new TreeNode(lastLevel.get(0));
        result = lca(root, lastLevel.get(0), lastLevel.get(1));
        int idx = 2;

        while(idx < lastLevel.size()){
            result = lca(root, result.val, lastLevel.get(idx++));
        }

        return result;
    }
}

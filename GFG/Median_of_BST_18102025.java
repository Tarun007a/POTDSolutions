package GFG;


// tc - O(n), sc - O(n) -> for call stack can be optimised to O(1) using morris
class Solution {
    private int totalNodes(Node root){
        if(root == null) return 0;
        return totalNodes(root.left) + totalNodes(root.right) + 1;
    }

    private int getMedian(Node root, int[] curr, int result){
        if(root == null) return -1;

        int left = getMedian(root.left, curr, result);

        if(left != -1) return left;
        if(curr[0] == result) return root.data;
        curr[0]++;

        int right = getMedian(root.right, curr, result);

        return Math.max(left, right);
    }

    public int findMedian(Node root) {
        int n = totalNodes(root);

        return getMedian(root, new int[]{1}, (n+1)/2);

    }
}

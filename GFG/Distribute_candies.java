package GFG;

// tc - O(n) sc - O(h)
// The idea is to count net candies sent or recieved form child
// needs a post order traversal as we first have to check the left subtree, then right and
// according to it reutrn net candies sent or recieved by the root node.
class Solution {
    int count = 0;
    private int countMin(Node root){
        if(root == null) return 0;

        int left = countMin(root.left);
        int right = countMin(root.right);

        count += Math.abs(left) + Math.abs(right);

        return left + right + root.data - 1;
    }
    public int distCandy(Node root) {
        countMin(root);
        return count;
    }
}
package GFG;

// tc - O(n) and sc - O(n)
class Solution {
    private Node helper(Node root, int l, int r){
        if(root == null) return null;

        Node left = helper(root.left, l, r);
        if(root.data > r) return left;

        Node right = helper(root.right, l, r);
        if(root.data < l) return right;

        root.left = left;
        root.right = right;
        return root;
    }
    Node removekeys(Node root, int l, int r) {
        return helper(root, l, r);
    }
}
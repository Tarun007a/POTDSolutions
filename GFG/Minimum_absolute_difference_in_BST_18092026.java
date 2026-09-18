package GFG;

/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/
// tc - O(n), sc - O(n)
class Solution {
    int val;
    int result;

    private void inorder(Node root) {
        if(root == null) return;

        inorder(root.left);

        if(val != -1) result = Math.min(result, root.data - val);
        val = root.data;
        inorder(root.right);
    }

    public int absDiff(Node root) {
        val = -1;
        result = Integer.MAX_VALUE;

        inorder(root);
        return result;
    }
}

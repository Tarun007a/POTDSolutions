package GFG;

// tc - O(n) and sc - O(n)
class Solution {
    private static void greaterSumTree(Node root, int[] add){
        if(root == null) return;

        greaterSumTree(root.right, add);

        int curr = root.data;
        root.data = add[0];
        add[0] += curr;

        greaterSumTree(root.left, add);
    }
    public static void transformTree(Node root) {
        greaterSumTree(root, new int[]{0});
    }
}

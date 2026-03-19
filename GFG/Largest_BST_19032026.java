package GFG;

// tc - O(n), sc - O(h)
class Solution {
    static int result;

    static class Factor{
        int min;
        int max;
        int size;

        public Factor(int min, int max, int size) {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    private static Factor findBST(Node root) {
        if(root == null) return new Factor(-1, -1, 0);

        Factor leftFactor = findBST(root.left);
        Factor rightFactor = findBST(root.right);

        if (leftFactor.size == -1 || rightFactor.size == -1) return new Factor(-1, -1, -1);
        if (leftFactor.max != -1 && leftFactor.max >= root.data) return new Factor(-1, -1, -1);
        if (rightFactor.min != -1 && rightFactor.min <= root.data) return new Factor(-1, -1, -1);

        int curr = leftFactor.size + rightFactor.size + 1;

        result = Math.max(result, curr);

        int min = root.data;
        int max = root.data;

        if(leftFactor.min != -1) min = Math.min(leftFactor.min, min);
        if(rightFactor.min != -1) min = Math.min(rightFactor.min, min);

        if(leftFactor.max != -1) max = Math.max(leftFactor.max, max);
        if(rightFactor.max != -1) max = Math.max(rightFactor.max, max);

        return new Factor(min, max, curr);
    }
    static int largestBst(Node root) {
        result = 0;
        findBST(root);
        return result;
    }
}

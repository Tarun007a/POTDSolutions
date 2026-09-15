package GFG;

// tc - O(nlogn), sc - O(n)
class Solution {
    PriorityQueue<Integer> pq;

    private void dfs(int depth, Node root) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            pq.add(depth);
        }

        dfs(depth+1, root.left);
        dfs(depth+1, root.right);
    }

    public int getCount(Node root, int k) {
        pq = new PriorityQueue<>();
        int result = 0;

        dfs(1, root);

        while(!pq.isEmpty() && k > 0) {
            k -= pq.remove();
            if(k >= 0) result++;
        }
        return result;
    }
}
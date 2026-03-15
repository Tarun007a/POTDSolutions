package GFG;

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

// tc - O(n), sc - O(n)
class Solution {
    int min;
    int max;

    class Pair {
        Node node;
        int idx;

        public Pair(Node node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    private void traverse(Node root, int idx) {
        if (root == null) return;

        min = Math.min(min, idx);
        max = Math.max(max, idx);

        traverse(root.left, idx-1);
        traverse(root.right, idx+1);
    }

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        min = max = 0;
        traverse(root, 0);
        int k = Math.abs(min);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));

        for(int i = min; i <= max; i++) {
            result.add(new ArrayList<>());
        }

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            Node node = curr.node;
            int idx = curr.idx;

            result.get(idx + k).add(node.data);
            if(node.left != null) q.add(new Pair(node.left, idx-1));
            if(node.right != null) q.add(new Pair(node.right, idx+1));
        }

        return result;
    }
}

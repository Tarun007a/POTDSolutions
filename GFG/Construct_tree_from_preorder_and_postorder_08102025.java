package GFG;

class Solution {
    int preIndex = 0;
    Node build(int[] pre, int[] post, int l, int r) {
        if (preIndex >= pre.length || l > r)
            return null;

        Node root = new Node(pre[preIndex++]);

        if (l == r || preIndex >= pre.length)
            return root;

        int nextVal = pre[preIndex];

        int i;
        for (i = l; i <= r; i++)
            if (post[i] == nextVal)
                break;

        if (i <= r) {
            root.left = build(pre, post, l, i);
            root.right = build(pre, post, i + 1, r - 1);
        }

        return root;
    }
    public Node constructTree(int[] pre, int[] post) {
        return build(pre, post, 0, post.length - 1);
    }
}

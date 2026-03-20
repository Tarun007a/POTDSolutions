package GFG;

/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

// tc - O(n), sc - O(n)
class Solution {
    Node pred;
    Node succ;
    int key;

    public void traverse(Node root){
        if(root == null) return;

        if(root.data < key) {
            if(pred == null || pred.data < root.data) pred = root;
        }

        if(root.data > key) {
            if(succ == null || succ.data > root.data) succ = root;
        }

        traverse(root.left);
        traverse(root.right);
    }

    public ArrayList<Node> findPreSuc(Node root, int key) {
        this.key = key;
        traverse(root);

        if(pred == null) pred = new Node(-1);
        if(succ == null) succ = new Node(-1);

        return new ArrayList<>(List.of(pred, succ));
    }
}
package GFG;

/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
// tc & sc - O(n)
class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        Queue<Node> q1 = new ArrayDeque<>();
        Queue<Node> q2 = new ArrayDeque<>();

        q1.add(root1);
        q2.add(root2);

        HashMap<Integer, Integer> mp1 = new HashMap<>();
        HashMap<Integer, Integer> mp2 = new HashMap<>();

        while(true) {
            int n1 = q1.size();
            int n2 = q2.size();

            for(int i = 0; i < n1; i++) {
                Node node = q1.remove();
                mp1.put(node.data, mp1.getOrDefault(node.data, 0)+1);

                if(node.left != null) q1.add(node.left);
                if(node.right != null) q1.add(node.right);
            }

            for(int i = 0; i < n2; i++) {
                Node node = q2.remove();
                mp2.put(node.data, mp2.getOrDefault(node.data, 0)+1);

                if(node.left != null) q2.add(node.left);
                if(node.right != null) q2.add(node.right);
            }

            if(mp1.size() != mp2.size()) return false;
            if(mp1.size() == 0) return true;

            for(int key : mp1.keySet()) {
                if(mp1.get(key) != mp2.getOrDefault(key, 0)) return false;
            }
            mp1.clear();
            mp2.clear();
        }
    }
}
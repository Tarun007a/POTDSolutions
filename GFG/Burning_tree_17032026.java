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
    private void fillParent(Node root, int target, Queue<Node> q, HashMap<Integer, Node> parentMap) {
        if(root.data == target) q.add(root);

        if(root.left != null) {
            parentMap.put(root.left.data, root);
            fillParent(root.left, target, q, parentMap);
        }
        if(root.right != null) {
            parentMap.put(root.right.data, root);
            fillParent(root.right, target, q, parentMap);
        }
    }

    public int minTime(Node root, int target) {
        int time = 0;

        HashMap<Integer, Node> parentMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Node> q = new ArrayDeque<>();

        fillParent(root, target, q, parentMap);
        visited.add(target);


        while(!q.isEmpty()) {
            int size = q.size();
            time++;

            for(int i = 0; i < size; i++) {
                Node node = q.remove();
                int data = node.data;

                if (node.left != null && !visited.contains(node.left.data)) {
                    q.add(node.left);
                    visited.add(node.left.data);
                }

                if (node.right != null && !visited.contains(node.right.data)) {
                    q.add(node.right);
                    visited.add(node.right.data);
                }

                if (parentMap.containsKey(data) && !visited.contains(parentMap.get(data).data)) {
                    q.add(parentMap.get(data));
                    visited.add(parentMap.get(data).data);
                }
            }
        }
        return time-1;
    }
}


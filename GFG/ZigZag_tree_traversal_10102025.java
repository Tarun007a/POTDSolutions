package GFG;

// TC - O(n) space O(n)
class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int currSize = q.size();
            int idx = 0;
            int[] curr = new int[currSize];

            for(int i = 0; i < currSize; i++){
                Node node = q.remove();
                curr[idx++] = node.data;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(flag){
                while(idx-- > 0) result.add(curr[idx]);
            }
            else{
                for(int i : curr) result.add(i);
            }
            flag = !flag;
        }
        return result;
    }
}
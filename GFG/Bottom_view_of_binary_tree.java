package GFG;


// if we go left we add -1 and if we go right we add +1 we sat it horizontal-value,
// Now for each diffrent values of horizontal-value we we add it in result
// can be aslo done by dfs. The main idea is to put a horizontal value and take it.
class Solution {
    static class Info{
        Node root;
        int horizontal;
        Info(Node root, int horizontal){
            this.root = root;
            this.horizontal = horizontal;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Info> q = new LinkedList<>();  // level order traversal or BFS
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;  // for leftmost to rightmost

        q.add(new Info(root, 0));
        // q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            // always add in the map so that the value of the same horizontal dist node gets updated along with the new entries
            map.put(curr.horizontal, curr.root);

            // Left child => horizontal distance - 1
            if(curr.root.left!=null){
                q.add(new Info(curr.root.left, curr.horizontal-1));
                min = Math.min(min, curr.horizontal-1);
            }
            // Right child => horizontal distance + 1
            if(curr.root.right!=null){
                q.add(new Info(curr.root.right, curr.horizontal+1));
                max = Math.max(max, curr.horizontal+1);
            }

        }

        for(int i = min;i<=max;i++){
            list.add(map.get(i).data);
        }
        return list;
    }
}
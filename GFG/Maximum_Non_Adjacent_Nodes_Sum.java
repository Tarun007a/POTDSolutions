package GFG;

// tc - O(n) visited all nodes twice
// sc - O(h+n) all node in mp + call stack
class Solution {
    HashMap<Node, Integer[]> dp;
    private int helper(Node root, boolean take){
        if(root == null) return 0;

        if(dp.containsKey(root)){
            if(take){
                if(dp.get(root)[0] != null) return dp.get(root)[0];
            }
            else if(dp.get(root)[1] != null) return dp.get(root)[1];
        }

        int max = helper(root.left, true) + helper(root.right, true);   // here we found not take so we can optimize the code storing this
        if(take){
            max = Math.max(max, helper(root.left, false) + helper(root.right, false) + root.data);
        }

        if(!dp.containsKey(root)) dp.put(root, new Integer[]{null, null});
        if(take) dp.get(root)[0] = max;
        else dp.get(root)[1] = max;
        return max;
    }
    public int getMaxSum(Node root) {
        dp = new HashMap<>();
        return Math.max(helper(root, true), helper(root, false));
    }
}
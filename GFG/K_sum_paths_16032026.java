package GFG;

// tc - O(n), sc - O(n)
class Solution {
    int k;
    private int dfs(Node root, int sum, HashMap<Integer, Integer> mp) {
        if(root == null) return 0;

        int currSum = sum + root.data;

        int requiredSum = currSum - k;

        int result = mp.getOrDefault(requiredSum, 0);

        mp.put(currSum, mp.getOrDefault(currSum, 0) + 1);

        result += dfs(root.left, currSum, mp) + dfs(root.right, currSum, mp);

        mp.put(currSum, mp.get(currSum) - 1);

        return result;
    }

    public int countAllPaths(Node root, int k) {
        this.k = k;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        return dfs(root, 0, mp);
    }
}
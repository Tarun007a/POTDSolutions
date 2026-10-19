package GFG;

// tc - O(n), sc - O(n)
class Solution {
    int n;
    Boolean[] canExit;
    boolean[] isVisited;

    private boolean helper(int i, int[] arr) {
        if(i >= n || i < 0) return true;
        if(canExit[i] != null) return canExit[i];

        if(isVisited[i]) return false;

        isVisited[i] = true;

        return canExit[i] = helper(i + arr[i], arr);
    }

    public int goodIndices(int[] arr) {
        n = arr.length;
        int result = 0;
        canExit = new Boolean[n];
        isVisited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(canExit[i] == null) helper(i, arr);
            if(canExit[i] == true) result++;
        }
        return result;
    }
}
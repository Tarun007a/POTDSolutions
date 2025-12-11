package Leetcode;

// leetcode - 3531
// tc - O(m), sc - O(n)
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int result = 0;
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        int[] top = new int[n+1];
        int[] bottom = new int[n+1];

        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];

            if(left[y] == 0) left[y] = right[y] = x;
            left[y] = Math.min(left[y], x);
            right[y] = Math.max(right[y], x);

            if(top[x] == 0) top[x] = bottom[x] = y;
            top[x] = Math.max(top[x], y);
            bottom[x] = Math.min(bottom[x], y);
        }

        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];

            if(left[y] < x && right[y] > x && top[x] > y && bottom[x] < y) result++;
        }
        return result;
    }
}

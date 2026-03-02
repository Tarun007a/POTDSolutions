package Leetcode;

// leetcode - 1536
// tc - O(n*n), sc - O(n)
class Solution {
    private int getCount(int[] row) {
        int n = row.length;
        int count = 0;

        for(int i = n-1; i >= 0; i--) {
            if(row[i] == 0) count++;
            else return count;
        }
        return count;
    }

    private int swap(int required, int idx, int[] count) {
        int n = count.length;
        int i = idx;
        int steps = 0;

        for(; i < n; i++) {
            if(count[i] >= required) {
                steps = i - idx;
                break;
            }
        }

        if(i == n) return -1;
        int val = count[i];
        while(i > idx) {
            count[i] = count[i-1];
            i--;
        }

        count[i] = val;
        return steps;
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n];
        int steps = 0;
        int required = n-1;

        for(int i = 0; i < n; i++) count[i] = getCount(grid[i]);

        for(int i = 0; i < n; i++) {
            int currSteps = swap(required, i, count);
            if(currSteps == -1) return -1;

            steps += currSteps;
            required--;
        }
        return steps;
    }
}
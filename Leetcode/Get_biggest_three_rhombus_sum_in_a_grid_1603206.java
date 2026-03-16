package Leetcode;

// leetcode - 1878
// tc - O(n*m*(min(n,m)) * log(n*m*(min(n,m))))
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>((a,b) -> b - a);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                set.add(grid[i][j]);

                for(int k = 1; ; k++){
                    if(i-k < 0 || i+k >= n || j-k < 0 || j+k >= m) break;

                    int sum = 0;
                    int r = i-k;
                    int c = j;

                    for(int d = 0; d < k; d++) sum += grid[r+d][c+d];
                    for(int d = 0; d < k; d++) sum += grid[i+d][j+k-d];
                    for(int d = 0; d < k; d++) sum += grid[i+k-d][j-d];
                    for(int d = 0; d < k; d++) sum += grid[i-d][j-k+d];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3,set.size());
        int[] res = new int[size];

        int idx = 0;

        for(int val : set) {
            if(idx == size) break;
            res[idx++] = val;
        }

        return res;
    }
}
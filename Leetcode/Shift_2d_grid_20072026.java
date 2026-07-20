package Leetcode;

// leetcode - 1260
// tc - O(n*m), sc - O(n*m)
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int elements = n*m;
        k = k%elements;
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
            for(int j = 0; j < m; j++) {
                int newVal = (m * i + j - k + elements) % elements;
                int newRow = newVal / m;
                int newCol = newVal % m;

                result.get(i).add(grid[newRow][newCol]);
            }
        }
        return result;
    }
}
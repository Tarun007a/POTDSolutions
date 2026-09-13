package Leetcodecontest.weekly519;

class Solution {
    private void leftShift(int[] row, int shift) {
        int n = row.length;
        shift = shift % n;

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = row[(i + shift)%n];
        }

        for(int i = 0; i < n; i++) row[i] = arr[i];
    }

    private void upShift(int j, int[][] grid, int shift) {
        int n = grid.length;
        shift = shift % n;

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = grid[(i + shift)%n][j];
        }

        for(int i = 0; i < n; i++) grid[i][j] = arr[i];
    }

    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for(int i = 0; i < n; i++) leftShift(grid[i], rowShift[i]);

        for(int i = 0; i < n; i++) upShift(i, grid, colShift[i]);

        return grid;
    }
}
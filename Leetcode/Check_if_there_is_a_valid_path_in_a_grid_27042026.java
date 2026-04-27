package Leetcode;

// leetcode - 1391
// tc - O(n*m), sc - O(n*m)
class Solution {
    int n;
    int m;

    static HashMap<Integer, List<Character>> move = new HashMap<>();

    static HashMap<Character, Set<Integer>> allowed = new HashMap<>();

    static {
        move.put(1, List.of('L', 'R'));
        move.put(2, List.of('U', 'D'));
        move.put(3, List.of('L', 'D'));
        move.put(4, List.of('R', 'D'));
        move.put(5, List.of('U', 'L'));
        move.put(6, List.of('U', 'R'));

        allowed.put('L', Set.of(1, 4, 6));
        allowed.put('R', Set.of(1, 3, 5));
        allowed.put('U', Set.of(2, 3, 4));
        allowed.put('D', Set.of(2, 5, 6));
    }

    private boolean helper(int i, int j, int[][] grid, boolean[][] isVisited) {
        if(i == n-1 && j == m-1) return true;

        isVisited[i][j] = true;

        for(char ch : move.get(grid[i][j])) {
            int newRow = i;
            int newCol = j;

            if(ch == 'L') newCol--;
            else if(ch == 'R') newCol++;
            else if(ch == 'U') newRow--;
            else newRow++;

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !isVisited[newRow][newCol]) {
                Set<Integer> set = allowed.get(ch);
                if(set.contains(grid[newRow][newCol])) {
                    if(helper(newRow, newCol, grid, isVisited)) return true;
                }
            }
        }
        return false;
    }

    public boolean hasValidPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] isVisited = new boolean[n][m];
        return helper(0, 0, grid, isVisited);
    }
}
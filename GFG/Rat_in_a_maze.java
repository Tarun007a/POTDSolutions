package GFG;
// tc - O(4^N) where N is total cells i.e. n*n
class Solution {
    private void helper(int i, int j, int n, int m, StringBuilder sb, ArrayList<String> result, boolean[][] isVisited, int[][] maze){
        if(i == n-1 && j == m-1){
            result.add(sb.toString());
            return;
        }

        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'}; // lexicographically sorted order

        for (int d = 0; d < 4; d++) {
            int row = i + di[d];
            int col = j + dj[d];

            if(row >=0 && col >= 0 && row < n && col < m && maze[row][col] == 1 && !isVisited[row][col]){
                isVisited[row][col] = true;
                sb.append(dir[d]);
                helper(row, col, n, m, sb, result, isVisited, maze);
                sb.deleteCharAt(sb.length()-1);
                isVisited[row][col] = false;
            }
        }
    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        ArrayList<String> result = new ArrayList<>();

        if (maze[0][0] == 0 || maze[n-1][m-1] == 0)
            return result;

        boolean[][] isVisited = new boolean[n][m];
        StringBuilder sb = new StringBuilder();

        isVisited[0][0] = true;
        helper(0, 0, n, m, sb, result, isVisited, maze);
        return result;
    }
}

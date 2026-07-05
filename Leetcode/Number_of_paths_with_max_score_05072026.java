package Leetcode;

// Leetcode - 1301
// tc & sc - o(n*n)
class Solution {
    public class Node {
        int row;
        int col;
        int score;

        public Node(int row, int col, int score) {
            this.row = row;
            this.col = col;
            this.score = score;
        }
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int mod = 1000_000_007;
        long[][][] visited = new long[n][n][2];
        int[] delRow = {-1, -1, 0};
        int[] delCol = {0, -1, -1};
        // pq fails because ways for a node was not finalized by its child nodes
        // but it came at top of pq and populated further
        // PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> b.score - a.score);
        Queue<Node> q = new ArrayDeque<>();

        for(long[][] a : visited) {
            for(long[] b : a) {
                b[0] = b[1] = -1;
            }
        }

        visited[n-1][n-1][0] = 0;
        visited[n-1][n-1][1] = 1;
        q.add(new Node(n-1, n-1, 0));

        while(!q.isEmpty()) {
            Node curr = q.remove();
            int row = curr.row;
            int col = curr.col;
            int score = curr.score;

            // System.out.println(curr);

            for(int i = 0; i < 3; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newCol >= 0) {
                    char ch = board.get(newRow).charAt(newCol);
                    if(ch == 'X') continue;
                    if(ch == 'E') ch = '0';

                    int newScore = score + (ch-'0');

                    if(newScore > visited[newRow][newCol][0]) {
                        visited[newRow][newCol][0] = newScore;
                        visited[newRow][newCol][1] = visited[row][col][1];
                        q.add(new Node(newRow, newCol, newScore));
                    }
                    else if(newScore == visited[newRow][newCol][0]) {
                        visited[newRow][newCol][1] =
                                (visited[newRow][newCol][1] + visited[row][col][1]) % mod;
                    }
                }
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(visited[i][j][0] + ":" + visited[i][j][1] + " ");
        //     }
        //     System.out.println();
        // }

        if(visited[0][0][0] == -1) return new int[]{0, 0};
        return new int[]{(int)visited[0][0][0], (int)visited[0][0][1]};
    }
}

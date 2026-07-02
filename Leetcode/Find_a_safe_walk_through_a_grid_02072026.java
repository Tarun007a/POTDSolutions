package Leetcode;

// leetcode - 3286
// tc - O((n*m)log(n*m)), sc - O(n*m)
class Solution {
    private class Node {
        int row;
        int col;
        int health;

        public Node(int row, int col, int health) {
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int[][] visited = new int[n][m];

        for(int[] row : visited) Arrays.fill(row, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.health-a.health);

        if(grid.get(0).get(0) == 1) health--;
        pq.add(new Node(0, 0, health));
        visited[0][0] = health;

        while(!pq.isEmpty()) {
            Node curr = pq.remove();
            int row = curr.row;
            int col = curr.col;
            int currHealth = curr.health;

            if(row == n-1 && col == m-1) return currHealth >= 1;

            for(int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newHealth = currHealth - grid.get(newRow).get(newCol);

                    if(newHealth > 0 && (visited[newRow][newCol] == -1 || newHealth > visited[newRow][newCol])){
                        pq.add(new Node(newRow, newCol, newHealth));
                        visited[newRow][newCol] = newHealth;
                    }
                }
            }
        }
        return false;
    }
}

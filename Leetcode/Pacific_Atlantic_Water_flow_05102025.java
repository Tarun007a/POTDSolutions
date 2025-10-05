package Leetcode;
// leetcode 417
// tc - O((n*m)*(n*m)) -> n*n*m*m
class Pair{
    int r,c;
    public Pair(int r,int c)
    {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    private void bfs(int i, int j, int m, int n, boolean[] oceans, int[][] heights)
    {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,j));
        boolean visited[][] = new boolean[m][n];
        visited[i][j] = true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            if(r==m-1 || c ==n-1) oceans[1]=true;
            if(c==0 || r == 0)oceans[0] = true;

            if(r > 0 && heights[r-1][c] <= heights[r][c] && !visited[r-1][c]){
                visited[r-1][c] = true;
                q.offer(new Pair(r-1, c));
            }
            if(r < m-1 && heights[r+1][c] <= heights[r][c] && !visited[r+1][c]){
                visited[r+1][c] = true;
                q.offer(new Pair(r+1, c));
            }
            if(c > 0 && heights[r][c-1] <= heights[r][c] && !visited[r][c-1]){
                visited[r][c-1] = true;
                q.offer(new Pair(r, c-1));
            }
            if(c < n-1 && heights[r][c+1] <= heights[r][c] && !visited[r][c+1]){
                visited[r][c+1] = true;
                q.offer(new Pair(r, c+1));
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean[] oceans = new boolean[2];
                bfs(i, j, m, n, oceans, heights);
                if(oceans[0] && oceans[1]){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    ans.add(new ArrayList<>(curr));
                }
            }
        }
        return ans;
    }
}
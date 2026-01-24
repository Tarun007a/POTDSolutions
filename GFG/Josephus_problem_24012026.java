package GFG;

// tc - O(n*n), sc - O(n)
class Solution {
    public int josephus(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) q.add(i);

        while(q.size() > 1){
            for(int j = 1; j < k; j++){
                q.add(q.remove());
            }
            q.remove();
        }
        return q.remove();
    }
}
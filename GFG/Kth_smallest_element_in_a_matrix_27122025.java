package GFG;

// tc - O(nlogk), sc - O(k)
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        for(int[] row : mat){
            for(int ele : row){
                pq.add(ele);
                if(pq.size() > k) pq.remove();
            }
        }
        return pq.peek();
    }
}

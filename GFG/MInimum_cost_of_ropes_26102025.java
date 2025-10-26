package GFG;

// tc - O(nlogn) sc - O(n)
class Solution {
    public static int minCost(int[] arr) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr) pq.add(i);

        while(pq.size() != 1){
            int rope1 = pq.remove();
            int rope2 = pq.remove();

            cost += rope1 + rope2;
            pq.add(rope1 + rope2);
        }
        return cost;
    }
}
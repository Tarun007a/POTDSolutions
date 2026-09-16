package GFG;

// tc - O(nlogn), sc - O(n)
class Solution {
    public int dominantPairs(int[] arr) {
        int result = 0;
        int n = arr.length;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < n/2; i++) {
            pq1.add(arr[i]);
            pq2.add(arr[i + (n/2)]);
        }

        while(!pq1.isEmpty()) {
            int ele = pq1.remove();

            while(!pq2.isEmpty() && pq2.peek() * 5 > ele) pq2.remove();

            result += pq2.size();
        }
        return result;
    }
}
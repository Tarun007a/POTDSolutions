package GFG;

// tc - O(n*logk), sc - o(k)
class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.add(arr[i]);
            while(pq.size() > k) pq.remove();

            if(pq.size() < k) result.add(-1);
            else result.add(pq.peek());
        }
        return result;
    }
}
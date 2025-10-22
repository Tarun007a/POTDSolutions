package GFG;

// tc - O(nlogk)
class Solution {
    public void nearlySorted(int[] arr, int k) {
        int n = arr.length;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++) pq.add(arr[i]);

        for(int i = k; i < n; i++){
            pq.add(arr[i]);
            arr[idx++] = pq.remove();
        }

        while(!pq.isEmpty()){
            arr[idx++] = pq.remove();
        }
    }
}

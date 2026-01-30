package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        int[] arr = new int[n];
        int idx = n/2;

        for(int i = 0; i < n; i++) arr[i] = q.remove();

        for(int i = 0; i < n/2; i++){
            q.add(arr[i]);
            q.add(arr[idx++]);
        }
    }
}

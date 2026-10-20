package GFG;

// tc - O(nlogn), sc - O(n)
class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        int prev = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        for(int num : arr) {
            int curr = num % 2;

            if(curr != prev) {
                while(!pq.isEmpty()) result.add(pq.remove());
                prev = curr;
            }

            pq.add(num);
        }

        while(!pq.isEmpty()) result.add(pq.remove());

        return result;
    }
}
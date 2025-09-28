package GFG;
class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        PriorityQueue<Integer> minPq = new PriorityQueue<>((a, b) -> arr[a]-arr[b]);
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> arr[b]-arr[a]);
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int st = 0;
        int len = 1;

        for(int j = 0; j < n; j++){
            minPq.add(j);
            maxPq.add(j);

            while(arr[maxPq.peek()] - arr[minPq.peek()] > x){
                i++;
                while(minPq.peek() < i) minPq.remove();
                while(maxPq.peek() < i) maxPq.remove();
            }
            if(j-i+1 > len){
                len = j-i+1;
                st = i;
            }
        }

        for(int j = st; j < st+len; j++) result.add(arr[j]);
        return result;
    }
}
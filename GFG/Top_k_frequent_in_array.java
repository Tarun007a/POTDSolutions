package GFG;

// time - nlog(k) space - O(max(arr))
class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        int n = arr.length;
        int[] freq = new int[100001];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq[a] == freq[b] ? a-b : freq[a]-freq[b]);
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i : arr) freq[i]++;

        for(int i : arr){
            if(set.contains(i)) continue;
            set.add(i);
            pq.add(i);
            if(pq.size() > k) pq.remove();
        }

        while(!pq.isEmpty()) result.add(pq.remove());
        Collections.reverse(result);
        return result;
    }
}

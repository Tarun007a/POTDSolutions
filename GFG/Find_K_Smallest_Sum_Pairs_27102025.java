package GFG;

// tc -O(k*logn) sc - O(n)
class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> {
            if(a.get(0) + arr2[a.get(1)] < b.get(0) + arr2[b.get(1)]) return -1;
            return 1;
        });

        for(int i : arr1){
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(i);
            curr.add(0);
            pq.add(curr);
        }

        while(k-- > 0){
            if(pq.isEmpty()) return result;
            ArrayList<Integer> curr = pq.remove();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(curr.get(0));
            temp.add(arr2[curr.get(1)]);

            result.add(temp);

            if(curr.get(1) < m-1){
                curr.set(1, curr.get(1)+1);
                pq.add(curr);
            }
        }
        return result;
    }
}

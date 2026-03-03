package GFG;

// tc - O(n), sc -O(1)
class Solution {
    public int totalElements(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int st = 0;
        int max = 0;

        for(int end = 0; end < n; end++) {
            int element = arr[end];
            mp.put(element, mp.getOrDefault(element, 0)+1);

            while(mp.size() > 2) {
                int toRemove = arr[st++];
                mp.put(toRemove, mp.get(toRemove)-1);
                if(mp.get(toRemove) == 0) mp.remove(toRemove);
            }
            max = Math.max(max, end-st+1);
        }
        return max;
    }
}

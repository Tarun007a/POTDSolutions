package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int longestSubseq(int[] arr) {
        int result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int num : arr) {
            int curr = mp.getOrDefault(num, 0);
            int max = Math.max(mp.getOrDefault(num - 1, 0),
                    mp.getOrDefault(num + 1, 0));
            if(curr <= max) mp.put(num, max+1);

            result = Math.max(result, mp.get(num));
        }
        return result;
    }
}

package GFG;

// tc - O(nlog(logm)), sc - O(n + m)
class Solution {
    private int getLength(long num, HashMap<Integer, Integer> mp) {
        if(num > 1000_000_000l) return -1;

        int curr = (int)num;

        if(!mp.containsKey(curr)) return -1;
        if(mp.get(curr) == 1) return 1;
        return 2 + getLength(num*num, mp);
    }

    public int maximumLength(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int num : nums) mp.put(num, mp.getOrDefault(num, 0)+1);

        for(int key : mp.keySet()) {
            if(key == 1) {
                int freq = mp.get(1);
                if((freq&1) == 0) freq--;
                result = Math.max(result, freq);
            }
            else result = Math.max(result, getLength(key, mp));
        }
        return result;
    }
}

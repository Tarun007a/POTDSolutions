package Leetcodecontest.weekly521;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int idx = 0;

        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        while(mp.size() > 0) {
            List<Integer> list = new ArrayList<>();
            for(int key : mp.keySet()) {
                list.add(key);
                result[idx++] = key;
            }

            for(int val : list) {
                mp.put(val, mp.get(val)-1);
                if(mp.get(val) == 0) mp.remove(val);
            }
        }
        return result;
    }
}
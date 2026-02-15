package Leetcodecontest.weekly489;

// leetcode - 3843
class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;
        int result = -1;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            if(!indexMap.containsKey(nums[i])) indexMap.put(nums[i], i);
        }

        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for(int num : freqMap.keySet()){
            int freq = freqMap.get(num);

            if(!mp.containsKey(freq)) mp.put(freq, new ArrayList<>());
            mp.get(freq).add(num);
        }

        // System.out.println(indexMap);

        for(int key : mp.keySet()){
            if(mp.get(key).size() == 1){
                if(result == -1) result = indexMap.get(mp.get(key).get(0));
                else {
                    if(result > indexMap.get(mp.get(key).get(0))){
                        result = indexMap.get(mp.get(key).get(0));
                    }
                }
            }
        }
        if(result == -1) return -1;
        return nums[result];
    }
}
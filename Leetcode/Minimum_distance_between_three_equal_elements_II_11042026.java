package Leetcode;

// leetcode - 3741
// tc - O(n), sc - O(n)
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int result = 10000000;
        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(!mp.containsKey(nums[i])) mp.put(nums[i], new ArrayList<>());
            mp.get(nums[i]).add(i);
        }

        for(int i : mp.keySet()){
            List<Integer> list = mp.get(i);
            int m = list.size();
            if(m < 3) continue;

            for(int st = 0; st <= m-3; st++){
                int curr = (list.get(st+1)-list.get(st)) + (list.get(st+2)-list.get(st+1)) + (list.get(st+2)-list.get(st));
                result = Math.min(result, curr);
            }
        }

        return result == 10000000 ? -1 : result;
    }
}
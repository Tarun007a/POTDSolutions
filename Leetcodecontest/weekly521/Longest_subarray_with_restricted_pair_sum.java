package Leetcodecontest.weekly521;

// done after the contest completed
class Solution {
    private List<List<Integer>> getAllPairs(int val, int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int need = val - nums[i];

            if(mp.containsKey(need)) {
                for(int idx : mp.get(need)) {
                    result.add(List.of(idx, i));
                }
            }

            if(!mp.containsKey(nums[i])) mp.put(nums[i], new ArrayList<>());
            mp.get(nums[i]).add(i);
        }
        return result;
    }

    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int result = 0;

        HashMap<Integer, List<Integer>> mp1 = new HashMap<>();
        List<List<Integer>> intervals = new ArrayList<>();

        for(int i = 0;i < n; i++) {
            if(!mp1.containsKey(nums[i])) mp1.put(nums[i], new ArrayList<>());
            mp1.get(nums[i]).add(i);
        }

        int[] maxAllowed = new int[n];
        Arrays.fill(maxAllowed, n);

        for(int num : mp1.keySet()) {
            List<List<Integer>> list = getAllPairs(num, nums);

            for(int idx : mp1.get(num)) {
                for(List<Integer> l : list) {
                    int min = Math.min(idx, Math.min(l.get(0), l.get(1)));
                    int max = Math.max(idx, Math.max(l.get(0), l.get(1)));

                    maxAllowed[min] = Math.min(maxAllowed[min], max);
                }
            }
        }

        for(int i = n-2; i >= 0; i--) {
            maxAllowed[i] = Math.min(maxAllowed[i], maxAllowed[i+1]);
        }

        for(int i = 0; i < n; i++) {
            int idx = i;
            result = Math.max(result, maxAllowed[i] - i);
        }
        return result;
    }
}
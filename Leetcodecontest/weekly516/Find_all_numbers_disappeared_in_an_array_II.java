package Leetcodecontest.weekly516;

class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int num : nums) set.add(num);

        int prev = lower;
        for(int i = lower; i <= upper; i++) {
            // System.out.println(prev + " " + i);
            if(set.contains(i)) {
                if(prev == i) {
                    prev++;
                    continue;
                }
                result.add(List.of(prev, i-1));
                prev = i+1;
            }
        }
        if(prev <= upper) result.add(List.of(prev, upper));
        return result;
    }
}
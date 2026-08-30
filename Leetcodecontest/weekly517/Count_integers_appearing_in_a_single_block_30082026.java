package Leetcodecontest.weekly517;

class Solution {
    public int countSpecialIntegers(int[] nums) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        for(int num : set) {
            boolean occured = false;
            boolean curr = false;
            boolean flag = true;

            for(int i : nums) {
                if(i == num) {
                    if(occured && !curr) {
                        flag = false;
                        break;
                    }
                    else if(!occured) {
                        occured = true;
                        curr = true;
                    }
                    else if(curr) continue;
                }
                else curr = false;
            }
            if(flag) result++;
        }

        return result;
    }
}


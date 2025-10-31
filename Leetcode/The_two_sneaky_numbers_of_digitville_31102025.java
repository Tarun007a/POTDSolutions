package Leetcode;

// leetcode - 3289
// tc - O(n) sc - O(1)
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] isPresent = new boolean[101];
        int[] result = {-1, -1};

        for(int i : nums){
            if(isPresent[i]){
                if(result[0] == -1) result[0] = i;
                else{
                    result[1] = i;
                    return result;
                }
            }
            isPresent[i] = true;
        }
        return result;
    }
}

package Leetcodecontest.weekly486;

class Solution {
    public void reverse(int i, int j, int[] nums){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i : nums){
            if(i >= 0) count++;
        }

        if(count == 0) return nums;

        k = k%count;

        int[] nonNegatives = new int[count];
        int idx = 0;

        for(int i : nums){
            if(i >= 0) nonNegatives[idx++] = i;
        }

        reverse(0, k-1, nonNegatives);
        reverse(k, nonNegatives.length-1, nonNegatives);
        reverse(0, nonNegatives.length-1, nonNegatives);

        idx = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                nums[i] = nonNegatives[idx++];
            }
        }
        return nums;
    }
}

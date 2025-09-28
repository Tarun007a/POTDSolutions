package Leetcode;

// leetcode 976

// This is because if the condition doesn't hold true i.e nums[i] + nums[j] !> nums[k]
// then it will also never be true for any values in left because as the array is sorted so in left the values will be always smaller that the current values.
// for i1 < i OR any j1 < j
// such that
// nums[i1] + nums[j1] > nums[k]
// is never true because
// becuase nums[i1] < nums[i] for all i1 < i
// Same is the case of nums[j].

class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = n-1; i >= 2; i--){
            if(nums[i-1]+nums[i-2] > nums[i]) return (nums[i]+nums[i-1]+nums[i-2]);
        }
        return 0;
    }
}

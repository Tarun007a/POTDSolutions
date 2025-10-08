package Leetcode;

class Solution {
    private int getCount(int[] potions, long val, long success){
        int m = potions.length;
        int left = 0;
        int right = m-1;
        int result = -1;

        while(left <= right){
            int mid = left-(left-right)/2;
            if(potions[mid]*val >= success){
                result = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        if(result == -1) return 0;
        return m-result;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            result[i] = getCount(potions, spells[i], success);
        }
        return result;
    }
}
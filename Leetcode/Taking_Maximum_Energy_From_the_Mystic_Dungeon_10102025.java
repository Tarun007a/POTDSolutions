package Leetcode;


// leetcode - 1347
// tc - O(n) if you notice we visit every node only once also the outer loop is k times and inner loop is n/k
// so k*n/k => n sc - O(1)
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++){
            int curr = 0;
            for(int j = i; j < n; j += k){
                curr = Math.max(curr, 0);
                curr += energy[j];
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}
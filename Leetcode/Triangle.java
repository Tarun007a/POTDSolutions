package Leetcode;

//leetcode 120
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] next = new int[n];
        int[] curr = new int[n];

        for(int j = 0; j < n; j++){
            next[j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                curr[j] = triangle.get(i).get(j) + Math.min(next[j], next[j+1]);
            }
            int[] temp = curr;
            curr = next;
            next = temp;
        }
        return next[0];
    }
}
package Leetcode;

// leetcode - 2946
// tc & sc - O(n * m)
class Solution {
    public boolean isSame(int[][] mat,int[] arr,int k){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != mat[k][i])return false;
        }
        return true;
    }
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        k = k%n;
        if(k == 0)return true;
        int[] arr = new int[n];
        for(int i = 0 ; i < mat.length ; i++){
            int t = 0;
            int st = n - k;
            for(int j = st ; j < n ; j++)arr[t++]=mat[i][j];
            for(int j = 0 ; j < st ; j++)arr[t++]=mat[i][j];
            if(!isSame(mat,arr,i)) return false;
        }
        return true;
    }
}
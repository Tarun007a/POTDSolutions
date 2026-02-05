package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int maxOnes(int arr[], int k) {
        int n = arr.length;
        int lo = 0;
        int zeros = 0;
        int result = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == 0) zeros++;
            while(zeros > k){
                if(arr[lo++] == 0) zeros--;
            }
            result = Math.max(result, i - lo + 1);
        }
        return result;
    }
}
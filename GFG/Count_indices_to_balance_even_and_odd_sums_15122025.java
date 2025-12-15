package GFG;

// tc - O(n), sc - O(1)
class Solution {
    public int cntWays(int[] arr) {
        int n = arr.length;
        int result = 0;
        int evenAhead = 0;
        int oddAhead = 0;
        int evenPrev = 0;
        int oddPrev = 0;

        for(int i = 0; i < n; i++){
            if((i&1) == 0) evenAhead += arr[i];
            else oddAhead += arr[i];
        }

        for(int i = 0; i < n; i++){
            int curr = arr[i];
            if((i&1) == 0){
                evenAhead -= curr;
                if(oddAhead + evenPrev == oddPrev + evenAhead) result++;
                evenPrev += curr;
            }
            else{
                oddAhead -= curr;
                if(oddAhead + evenPrev == oddPrev + evenAhead) result++;
                oddPrev += curr;
            }
        }
        return result;
    }
}


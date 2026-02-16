package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    static boolean canAttend(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int prev = 0;

        for(int[] meeting : arr){
            if(meeting[0] < prev) return false;
            prev = meeting[1];
        }

        return true;
    }
}
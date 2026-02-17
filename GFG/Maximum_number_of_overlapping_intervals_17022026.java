package GFG;

// tc - O(max), sc - O(max)
class Solution {
    public static int overlapInt(int[][] arr) {
        int result = 0;
        int max = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .max()
                .getAsInt();

        int[] time = new int[max+2];

        for(int[] interval : arr){
            time[interval[0]]++;
            time[interval[1]+1]--;
        }

        for(int i = 1; i <= max; i++){
            time[i] += time[i-1];
            result = Math.max(result, time[i]);
        }

        return result;
    }
}

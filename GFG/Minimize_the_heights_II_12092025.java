package GFG;
import java.util.Arrays;

// Time complexity - O(nlogn) and space - O(1)
// 12th september 2025
public class Minimize_the_heights_II_12092025 {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int smallest = arr[0]+k;
        int largest = arr[n-1]-k;
        int result = arr[n-1]-arr[0];

        for(int i = n-1; i > 0; i--){
            int min = Math.min(smallest, arr[i]-k);
            int max = Math.max(arr[i-1]+k, largest);

            if(min < 0) break;
            result = Math.min(max-min, result);
        }
        return result;
    }
}
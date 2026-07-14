package GFG;

// class Solution {
//     private boolean isPossible(int x, int[] arr) {
//         for(int i : arr) {
//             if(i >= x) x -= (i - x);
//             else x += (x - i);
//             if(x < 0) return false;
//             if(x >= 10000) return true;
//         }
//         return true;
//     }

//     public int find(int[] arr) {
//         int lo = 1;
//         int hi = 10000;
//         int result = -1;

//         while(lo <= hi) {
//             int mid = lo - (lo - hi) / 2;
//             if(isPossible(mid, arr)) {
//                 result = mid;
//                 hi = mid-1;
//             }
//             else lo = mid+1;
//         }
//         return result;
//     }
// }




// when x > arr[i], x = x + (x - arr[i]);
// and when x <= arr[i], x = x - (arr[i] - x);
// expand it x = x + x - arr[i] this is for both first and second case
// x = 2*x - arr[i] and we need x >= 2*x - arr[i]
// so need = 2*x - arr[i]

// After processing this element,
// I need at least need to finish the remaining array, so we will traverse
// from backward and need will be equal to the value which we need to survive
// the array ahead
// need = 2*x - arr[i] -> 2*x ≥ need + arr[i] -> x >= (need + arr[i]) / 2
// x must be an integer x = upper_bound((need + arr[i]) / 2)


class Solution {
    public int find(int[] arr) {
        int need = 0;

        for(int i = arr.length-1; i >= 0; i--) {
            need = (need + arr[i] + 1) / 2;
        }
        return need;
    }
}


package GFG;

// tc - O(n), sc - O(n)
// class Solution {
//     public void sortIt(int[] arr) {
//         int n = arr.length;

//         PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);
//         PriorityQueue<Integer> even = new PriorityQueue<>();

//         for(int ele : arr) {
//             if(ele % 2 == 0) even.add(ele);
//             else odd.add(ele);
//         }

//         for(int i = 0; i < n; i++) {
//             if(!odd.isEmpty()) arr[i] = odd.remove();
//             else arr[i] = even.remove();
//         }
//     }
// }




// Arrays.sort(arr, stIdx, endIdx+1)  -> we can also pass start idx and end idx(not inclusive) to sort
// tc - O(n), sc - O(1)
// class Solution {
//     public void sortIt(int[] arr) {
//         int n = arr.length;
//         int left = 0;

//         for (int i = 0; i < n; i++) {
//             if (arr[i] % 2 == 1) {
//                 int temp = arr[i];
//                 arr[i] = arr[left];
//                 arr[left] = temp;
//                 left++;
//             }
//         }

//         Arrays.sort(arr, 0, left);

//         int st = 0;
//         int end = left-1;

//         while(st < end) {
//             int temp = arr[st];
//             arr[st] = arr[end];
//             arr[end] = temp;
//             st++; end--;
//         }


//         Arrays.sort(arr, left, n);
//     }
// }


// tc - O(nlogn), sc - O(1)
// Convert all odd elements to negative, making larger odd values more negative (e.g., 7 becomes -7).
// During sorting, these more negative values (i.e., originally bigger odds) are pushed further to the left, achieving descending order for odds.
class Solution {
    public void sortIt(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            if(arr[i] % 2 == 1) arr[i] = -arr[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            if(arr[i] % 2 == 0) break;
            arr[i] = Math.abs(arr[i]);
        }
    }
}



// using comparator is one way but in java we cannot do it in O(1) space as
// we cannot pass comparator or a primitive type so you need to first convert
// the int[] -> Integer[] to pass comparator and this takes O(n) space



























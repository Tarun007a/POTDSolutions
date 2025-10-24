package GFG;

// tc - O(n log(n/k))  n/k as we have lastEle and count of size n/k
// class Solution {
//     private int binarySearch(int num, int k, int[] count, int[] lastEle){
//         int lo = 0;
//         int hi = count.length-1;
//         int result = -1;

//         while(lo <= hi){
//             int mid = lo-(lo-hi)/2;

//             if(count[mid] == 0 || lastEle[mid] > num) hi = mid-1;

//             else if(lastEle[mid] == num-1){
//                 result = mid;
//                 if(count[mid] >= k) lo = mid+1;
//                 else hi = mid-1;
//             }

//             else lo = mid+1;
//         }
//         return result;
//     }

//     private int getEmpty(int[] lastEle){
//         int n = lastEle.length;
//         int lo = 0;
//         int hi = n-1;
//         int result = -1;
//         if(lastEle[hi] != 0) return -1;

//         while(lo <= hi){
//             int mid = lo-(lo-hi)/2;
//             if(lastEle[mid] == 0){
//                 result = mid;
//                 hi = mid-1;
//             }
//             else lo = mid+1;
//         }
//         return result;
//     }

//     public boolean isPossible(int[] arr, int k) {
//         int n = arr.length;
//         int len = n/k;
//         int[] lastEle = new int[len];
//         int[] count = new int[len];

//         for(int i : arr){
//             int idx = binarySearch(i, k, count, lastEle);

//             if(idx == -1){
//                 idx = getEmpty(lastEle);
//                 if(idx == -1) return false;
//             }

//             count[idx]++;
//             lastEle[idx] = i;
//         }
//         return true;
//     }
// }


// standard approach - nlog(n) , sc - O(n)
// the first one is slightly more efficient as n/k but in worst case k = 1 n/k => n so
// in worst case both are nlogn
// approach is in mp we put last_number and a pq which stores length of all the sequences
// ending at last_number and we take the sequence with min size so we use min heap

class Solution {
    public boolean isPossible(int[] arr, int k) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int x : arr) {
            if (map.containsKey(x - 1)) {
                PriorityQueue<Integer> prevHeap = map.get(x - 1);
                int len = prevHeap.poll();
                if (prevHeap.isEmpty()) map.remove(x - 1);

                map.computeIfAbsent(x, t -> new PriorityQueue<>()).offer(len + 1);
            } else {
                map.computeIfAbsent(x, t -> new PriorityQueue<>()).offer(1);
            }
        }

        for (PriorityQueue<Integer> heap : map.values()) {
            for (int len : heap) {
                if (len < k) return false;
            }
        }

        return true;
    }
}

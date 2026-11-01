package Leetcode;

// Increasing n-1 numbers essentially means reducing that ith number relatively.
// Reduce every number to min and each move takes 1 operation
// leetcode - 453
// tc - O(nlogn), sc - O(1)
// class Solution {
//     class Pair {
//         int num;
//         int occ;

//         public Pair(int num, int occ) {
//             this.num = num;
//             this.occ = occ;
//         }
//     }

//     public int minMoves(int[] nums) {
//         int n = nums.length;
//         int result = 0;

//         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.num - a.num);
//         HashMap<Integer, Integer> mp = new HashMap<>();

//         for(int num : nums) {
//             mp.put(num, mp.getOrDefault(num, 0) + 1);
//         }

//         for(int key : mp.keySet()) {
//             pq.add(new Pair(key, mp.get(key)));
//         }

//         while(pq.size() > 1) {
//             Pair p1 = pq.remove();
//             Pair p2 = pq.remove();

//             result += (p1.num - p2.num) * p1.occ;
//             p2.occ += p1.occ;
//             pq.add(p2);
//         }
//         return result;
//     }
// }




// tc - O(n), sc - O(1)
// tc - O(nlogn), sc - O(1)
class Solution {
    public int minMoves(int[] nums) {
        int result = 0;
        int min = nums[0];

        for(int num : nums) {
            min = Math.min(min, num);
        }

        for(int num : nums) {
            result += num - min;
        }

        return result;
    }
}
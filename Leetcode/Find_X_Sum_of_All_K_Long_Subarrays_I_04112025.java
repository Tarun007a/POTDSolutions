package Leetcode;

// leetcode - 3318
// tc - n * (n + nlogx), sc - O(n)
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        HashMap<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (mp.get(a)-mp.get(b) == 0) ? a-b : mp.get(a)-mp.get(b));
        for(int i = 0; i < k-1; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        for(int i = k-1; i < n; i++){
            int curr = 0;

            if(i != k-1){
                int toRemove = nums[i-k];
                mp.put(toRemove, mp.get(toRemove)-1);
                if(mp.get(toRemove) == 0) mp.remove(toRemove);
            }
            int toAdd = nums[i];
            mp.put(toAdd, mp.getOrDefault(toAdd, 0)+1);

            for(int ele : mp.keySet()){
                pq.add(ele);
                if(pq.size() > x) pq.remove();
            }

            // System.out.println(pq);

            while(!pq.isEmpty()){
                int ele = pq.remove();
                curr += ele * mp.get(ele);
            }
            result[i-k+1] = curr;
        }
        return result;
    }
}
package Leetcode;

// leetcode - 3488
// tc- O(nlogn), sc - o(n)
class Solution {
    private int search(int idx, List<Integer> list){
        int lo = 0;
        int hi = list.size()-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(list.get(mid) == idx)return mid;
            else if(list.get(mid) < idx)lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }

    private int helper(int idx, List<Integer> list, int total){
        int n = list.size();
        if(n == 1){
            return -1;
        }
        int listIdx = search(idx, list);
        if(listIdx == -1)return -1;

        int min = 0;

        if(listIdx == 0){
            min = list.get(listIdx) + total - list.get(n-1);
        }
        else{
            min = list.get(listIdx) - list.get(listIdx-1);
        }

        if(listIdx == n-1){
            min = Math.min(min, total - list.get(n-1) + list.get(0));
        }
        else{
            min = Math.min(min, list.get(listIdx+1) - list.get(listIdx));
        }
        return min;
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            int ele = nums[i];
            if(!mp.containsKey(ele))mp.put(ele, new ArrayList<>());
            mp.get(ele).add(i);
        }

        for(int i = 0; i < m; i++){
            int idx = queries[i];
            int ele = nums[idx];

            List<Integer> list = mp.get(ele);
            int curr = helper(idx, list, n);

            result.add(curr);
        }
        return result;
    }
}
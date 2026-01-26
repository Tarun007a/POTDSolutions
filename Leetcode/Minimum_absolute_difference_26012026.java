package Leetcode;

// leetcode - 1200
// tc - O(nlogn), sc - O(1)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int i = 1; i < n; i++){
            minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        }

        for(int i = 1; i < n; i++){
            if(arr[i] - arr[i-1] == minDiff) result.add(List.of(arr[i-1], arr[i]));
        }

        return result;
    }
}

package GFG;

// tc - O(high-low), sc - O(n)
class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr) set.add(ele);

        for(int i = low; i <= high; i++){
            if(!set.contains(i)) result.add(i);
        }
        return result;
    }
}

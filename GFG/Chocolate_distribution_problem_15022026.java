package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    public int findMinDiff(ArrayList<Integer> chocolate, int m) {
        int n = chocolate.size();
        Collections.sort(chocolate);

        int st = 0;
        int end = m-1;
        int result = Integer.MAX_VALUE;

        while(end < n){
            result = Math.min(result, chocolate.get(end) - chocolate.get(st));
            st++;
            end++;
        }
        return result;
    }
}

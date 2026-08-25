package GFG;

// tc & sc - O(n)
class Solution {
    public int minMoves(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int max = 0;

        for(int ele : arr) {
            if(mp.containsKey(ele-1)) mp.put(ele, mp.get(ele-1)+1);
            else mp.put(ele, 1);

            max = Math.max(max, mp.get(ele));
        }
        return arr.length-max;
    }
}
package Leetcode;

// leetcode - 2943
// tc - O(n+m), sc - O(n+m)
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        HashSet<Integer> setH = new HashSet<>();
        HashSet<Integer> setV = new HashSet<>();
        int maxH = 1;
        int maxV = 1;

        for(int bar : hBars) setH.add(bar);
        for(int bar : vBars) setV.add(bar);

        for(int ele : hBars){
            if(!setH.contains(ele-1)) {
                int bar = ele;
                while(setH.contains(bar)) bar++;
                maxH = Math.max(maxH, bar-ele);
            }
        }

        for(int ele : vBars){
            if(!setV.contains(ele-1)) {
                int bar = ele;
                while(setV.contains(bar)) bar++;
                maxV = Math.max(maxV, bar-ele);
            }
        }
        int side = Math.min(maxH, maxV)+1;
        return side * side;
    }
}

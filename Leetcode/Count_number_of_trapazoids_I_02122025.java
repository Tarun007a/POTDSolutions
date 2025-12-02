package Leetcode;

// leetcode 3623
// tc - O(n), sc - O(n)
class Solution {
    public int countTrapezoids(int[][] points) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        long total = 0;
        long mod = 1000000007;

        for(int[] point : points){
            mp.put(point[1], mp.getOrDefault(point[1], 0)+1);
        }


        for(int key : mp.keySet()){
            long currPoints = (long)mp.get(key) - 1L;
            long currLines = ((currPoints)*(currPoints+1))/2;
            total += currLines;
            mp.put(key, (int)currLines);
        }

        long result = 0;

        for(int key : mp.keySet()){
            long currLines = (long)(mp.get(key));
            total -= currLines;
            result += total*currLines;
            result = result%mod;
        }
        return (int)result;
    }
}
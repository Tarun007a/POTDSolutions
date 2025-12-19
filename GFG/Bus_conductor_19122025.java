package GFG;

// tc - O(nlogn + mlogm), sc - O(1)
class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        int n = chairs.length;
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        int sum = 0;

        for(int i = 0; i < n; i++) sum += Math.abs(chairs[i]-passengers[i]);
        return sum;
    }
}


package Leetcodecontest.Weekly515;

class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int idx = -1;
        int dist = Integer.MAX_VALUE;
        int i = 0;

        for(int[] drone : drones) {
            int curr = Math.abs(drone[0] - target[0])
                    + Math.abs(drone[1] - target[1]);

            if(curr <= drone[2] && dist > curr) {
                dist = curr;
                idx = i;
            }
            i++;
        }
        return idx;
    }
}
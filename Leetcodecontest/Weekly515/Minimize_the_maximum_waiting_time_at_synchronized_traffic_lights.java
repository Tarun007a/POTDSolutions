package Leetcodecontest.Weekly515;

class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n = lights.length;
        int m = arrivalTime.length;

        int max = lights[0];
        int wait = 0;

        for(int light : lights) max = Math.max(max, light);

        for(int time : arrivalTime) {
            int r = time % period;
            if(r >= max) wait = Math.max(wait, period - r);
        }

        return wait;
    }
}
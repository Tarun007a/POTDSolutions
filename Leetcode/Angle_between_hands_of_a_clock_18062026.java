// leetcode - 1344
// tc & sc - O(1)
class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteHand = minutes * 6;
        double hourHand = (hour * 30) + (minutes * 0.5);
        double diff = Math.abs(hourHand - minuteHand);

        return Math.min(diff, 360 - diff);
    }
}
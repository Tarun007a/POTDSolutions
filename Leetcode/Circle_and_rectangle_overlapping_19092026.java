package Leetcode;

// leetcode - 1401
// tc - O(max(x1, x2) + max(y1, y2)), sc - O(1)
class Solution {
    private int getDistance(int x1, int y1, int x2, int y2) {
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);

        return (int)Math.sqrt(x*x + y*y);
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if(xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2)
            return true;

        for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
            int dist1 = getDistance(xCenter, yCenter, x, y1);
            int dist2 = getDistance(xCenter, yCenter, x, y2);

            // System.out.println(dist1 + " " + dist2);

            if(dist1 <= radius || dist2 <= radius) return true;
        }

        for(int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
            int dist1 = getDistance(xCenter, yCenter, x1, y);
            int dist2 = getDistance(xCenter, yCenter, x2, y);

            // System.out.println(dist1 + " " + dist2);

            if(dist1 <= radius || dist2 <= radius) return true;
        }

        return false;
    }
}
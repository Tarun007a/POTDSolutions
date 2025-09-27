package Leetcode;

// leetcode 812
// O(n^3) time and O(1) space
// can be optimized by convex hull(learn this)
class Solution {
    private double getArea(int[] p1, int[] p2, int[] p3){
        return 0.5 * (double)Math.abs(p1[0] * (p2[1]-p3[1])
                + p2[0] * (p3[1]-p1[1])
                + p3[0] * (p1[1]-p2[1]));
    }
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double result = 0;

        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    result = Math.max(result, getArea(points[i], points[j], points[k]));
                }
            }
        }
        return result;
    }
}

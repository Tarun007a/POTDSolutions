package Leetcode;

// leetcode - 3047
// tc - O(n*n), sc - O(1)
class Solution {
    private static class Rectangle implements Comparable<Rectangle>{
        int x1;
        int y1;
        int x2;
        int y2;
        public Rectangle(int x1, int x2, int y1, int y2){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        public int compareTo(Rectangle r2){
            if(this.x1 != r2.x1) return x1 - r2.x1;
            return (r2.y2 - r2.y1) - (this.y2 - this.y1);
        }
    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long result = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int r1x1 = bottomLeft[i][0];
                int r1y1 = bottomLeft[i][1];
                int r1x2 = topRight[i][0];
                int r1y2 = topRight[i][1];

                int r2x1 = bottomLeft[j][0];
                int r2y1 = bottomLeft[j][1];
                int r2x2 = topRight[j][0];
                int r2y2 = topRight[j][1];

                int len = 0;
                int width = 0;
                if((r1x1 <= r2x1 && r1x2 >= r2x1) || (r2x1 <= r1x1 && r2x2 >= r1x1)) len = Math.min(r1x2, r2x2) - Math.max(r1x1, r2x1);
                if((r1y1 <= r2y1 && r1y2 >= r2y1) || (r2y1 <= r1y1 && r2y2 >= r1y1)) width = Math.min(r1y2, r2y2) - Math.max(r1y1, r2y1);

                long side = (long)Math.min(len, width);

                result = Math.max(result, side * side);
            }
        }
        return result;
    }
}




package Leetcode;

// leetocde 407
// time - O(m⋅n⋅log(m⋅n))
// this will not work as it is like a 3d simulation
// class Solution {
//     private int trapRainWater(int[] height){
//         int n = height.length;
//         int result = 0;
//         int left = 0;
//         int right = n-1;
//         int leftMax = height[0];
//         int rightMax = height[n-1];

//         while(left < right){
//             if(height[left] < height[right]){
//                 if(height[left] >= leftMax) leftMax = height[left];
//                 else result += leftMax-height[left];
//                 left++;
//             }
//             else{
//                 if(height[right] >= rightMax) rightMax = height[right];
//                 else result += rightMax-height[right];
//                 right--;
//             }
//         }
//         return result;
//     }
//     public int trapRainWater(int[][] heightMap) {
//         int result = 0;
//         for(int[] height : heightMap) result += trapRainWater(height);
//         return result;
//     }
// }


//mik
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // Min-heap to store {height, {i, j}}
        PriorityQueue<int[]> boundaryCells = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[][] visited = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            boundaryCells.offer(new int[]{heightMap[row][0], row, 0});
            visited[row][0] = true;
            boundaryCells.offer(new int[]{heightMap[row][n - 1], row, n - 1});
            visited[row][n - 1] = true;
        }

        for (int col = 0; col < n; col++) {
            boundaryCells.offer(new int[]{heightMap[0][col], 0, col});
            visited[0][col] = true;
            boundaryCells.offer(new int[]{heightMap[m - 1][col], m - 1, col});
            visited[m - 1][col] = true;
        }

        int water = 0;
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while (!boundaryCells.isEmpty()) {
            int[] cell = boundaryCells.poll();
            int height = cell[0];
            int i = cell[1];
            int j = cell[2];

            for (int[] dir : directions) {
                int i2 = i + dir[0];
                int j2 = j + dir[1];

                if (i2 >= 0 && i2 < m && j2 >= 0 && j2 < n && !visited[i2][j2]) {
                    water += Math.max(height - heightMap[i2][j2], 0);
                    boundaryCells.offer(new int[]{Math.max(height, heightMap[i2][j2]), i2, j2});
                    visited[i2][j2] = true;
                }
            }
        }
        return water;
    }
}
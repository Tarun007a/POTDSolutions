package Leetcode;

// leetcode - 2033
// tc - O(nlogn), sc - O(n)
class Solution {

    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int result = 0;

        for (int row = 0; row < grid.length; row++) {  //flatten it to 1d list
            for (int col = 0; col < grid[0].length; col++) {
                list.add(grid[row][col]);
            }
        }

        // Sort numsArray in non-decreasing order to easily find the median
        Collections.sort(list);

        int length = list.size();
        int median = list.get(length / 2);  //get median

        for (int num : list) {
            // If the remainder when divided by x is different, return -1
            if (Math.abs(median - num) % x != 0)return -1;
            // Add the number of operations required to make the current number equal to finalCommonNumber
            result += Math.abs(median - num) / x;
        }

        return result;
    }
}

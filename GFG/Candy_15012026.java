package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int minCandy(int[] arr) {
        int n = arr.length;
        int[] candies = new int[n];

        for (int i = 0; i < n; i++) candies[i] = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int c : candies) total += c;

        return total;
    }
}

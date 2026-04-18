package GFG;

class Solution {
    public int maxOnes(int arr[]) {
        int ones = 0;

        for (int num : arr) {
            if (num == 1)
                ones++;
        }

        int maxGain = 0;
        int current = 0;

        for (int num : arr) {

            if (num == 0)
                current += 1;
            else
                current -= 1;

            if (current < 0)
                current = 0;

            if (current > maxGain)
                maxGain = current;
        }

        return ones + maxGain;
    }
}
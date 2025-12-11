package GFG;

// tc - O(n) sc - O(1)
class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        int m = arr.length;

        // If original array has size n, we know:
        // m = n * (n - 1) / 2  => solve quadratic to find n
        int n = (int) ((1 + Math.sqrt(1 + 8 * m)) / 2);

        ArrayList<Integer> result = new ArrayList<>();
        if(m == 1){
            result.add(0);
            result.add(arr[0]);
            return result;
        }

        int S01 = arr[0];
        int S02 = arr[1];
        int S12 = arr[n - 1];

        result.add((S01 + S02 - S12) / 2);
        result.add(S01 - result.get(0));
        result.add(S02 - result.get(0));

        for (int i = 3; i < n; i++) {
            result.add(arr[i - 1] - result.get(0));
        }

        return result;
    }
}

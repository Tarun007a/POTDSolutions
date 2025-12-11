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

        // we got here sum of 0 and 1, 0 and 2 and 1 and 2 to find the 0th element
        int S01 = arr[0];
        int S02 = arr[1];
        int S12 = arr[n - 1];

        // when we find the zeorth element then all are just substract by 0
        result.add((S01 + S02 - S12) / 2);

        // we traverse till n only and till n all values are 0th + val, so just remove
        // the 0th values
        for (int i = 1; i < n; i++) {
            result.add(arr[i - 1] - result.get(0));
        }

        return result;
    }
}
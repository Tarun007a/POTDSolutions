package GFG;

// tc - O(n+m), sc - O(1)
class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = m-1;

        int minDiff = Integer.MAX_VALUE;
        List<Integer> result = Arrays.asList(-1, -1);

        while(i < n && j >= 0){
            int curr = arr1[i] + arr2[j];

            if(minDiff > Math.abs(x - curr)) {
                minDiff = Math.abs(x - curr);
                result.set(0, arr1[i]);
                result.set(1, arr2[j]);
            }
            if(curr < x) i++;
            else j--;
        }
        return new ArrayList<>(result);
    }
}

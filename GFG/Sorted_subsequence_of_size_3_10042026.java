package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;

        int[] greatest = new int[n];
        greatest[n-1] = arr[n-1];

        for(int i = n-2; i >= 0; i--) {
            greatest[i] = Math.max(greatest[i+1], arr[i]);
        }

        int smallest = arr[0];

        for(int i = 1; i < n-1; i++) {
            smallest = Math.min(smallest, arr[i]);

            if(arr[i] > smallest && arr[i] < greatest[i]) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(smallest);
                result.add(arr[i]);
                result.add(greatest[i]);
                return result;
            }
        }
        return new ArrayList<>();
    }
}

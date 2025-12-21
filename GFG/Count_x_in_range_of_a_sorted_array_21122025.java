package GFG;

// tc - O(q * log n), sc - O(1)
class Solution {
    private int binarySearchLower(int val, int lo, int hi, int[] arr){
        int result = -1;

        while(lo <= hi){
            int mid = lo - (lo - hi) / 2;
            if(arr[mid] == val){
                result = mid;
                hi = mid - 1;
            }
            else if(arr[mid] < val) lo = mid + 1;
            else hi = mid - 1;
        }

        return result;
    }

    private int binarySearchUpper(int val, int lo, int hi, int[] arr){
        int result = -1;

        while(lo <= hi){
            int mid = lo - (lo - hi) / 2;
            if(arr[mid] == val){
                result = mid;
                lo = mid + 1;
            }
            else if(arr[mid] < val) lo = mid + 1;
            else hi = mid - 1;
        }

        return result;
    }

    private int getFreq(int[] query, int[] arr){
        int lo = query[0];
        int hi = query[1];
        int val = query[2];

        int left = binarySearchLower(val, lo, hi, arr);
        if(left == -1) return 0;
        int right = binarySearchUpper(val, lo, hi, arr);
        return right - left + 1;
    }

    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int[] query : queries){
            result.add(getFreq(query, arr));
        }

        return result;
    }
}

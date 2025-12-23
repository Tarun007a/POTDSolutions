package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    private int lowerBound(int val, int[] arr){
        int lo = 0;
        int hi = arr.length-1;
        int result = arr.length;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] >= val){
                result = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }

    private int upperBound(int val, int[] arr){
        int lo = 0;
        int hi = arr.length-1;
        int result = -1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] <= val){
                result = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return result;
    }

    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        ArrayList<Integer> result = new ArrayList<>();

        for(int[] query : queries){
            int lo = lowerBound(query[0], arr);
            int hi = upperBound(query[1], arr);
            if(lo > hi) result.add(0);
            else result.add(hi-lo+1);
        }
        return result;
    }
}


package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        ArrayList<int[]> result = new ArrayList<>();
        int st = -1;
        int end = 0;

        for(int[] event : arr){
            if(st == -1){
                st = event[0];
                end = event[1];
            }
            else if(event[0] <= end)end = Math.max(end, event[1]);
            else{
                int[] curr = new int[]{st, end};
                result.add(curr);
                st = event[0];
                end = event[1];
            }
        }

        int[] curr = new int[]{st, end};
        result.add(curr);
        return result;
    }
}

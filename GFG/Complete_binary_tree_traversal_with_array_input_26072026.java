package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        int size = 1;
        int i = 0;
        int n = arr.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while(i < n) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < size && i < n; j++) {
                list.add(arr[i++]);
            }
            Collections.sort(list);
            size *= 2;
            result.add(list);
        }
        return result;
    }
}
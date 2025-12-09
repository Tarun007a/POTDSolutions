package GFG;

// let we got 3 so at index 3 what ever is the number we will flip its sighn
// we flip the value itself by this we mark also preserve the number which was present
class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int ele = Math.abs(arr[i]);
            int idx = ele - 1;

            if (arr[idx] < 0) result.add(ele);
            else arr[idx] = -arr[idx];
        }
        return result;
    }
}

package GFG;

// tc - O(n+m), sc - O(1)
class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while(i < n && j < m) {
            if(a[i] < b[j]) i++;
            else if(a[i] > b[j]) j++;
            else {
                result.add(a[i]);
                i++;
                j++;
                while(i < n && a[i] == a[i-1]) i++;
            }
        }
        return result;
    }
}
package GFG;

// tc - O(size1 + size2 + size3), sc - o(1)
class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        int size1 = a.length;
        int size2 = b.length;
        int size3 = c.length;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int prev = -1000000;
        ArrayList<Integer> result = new ArrayList<>();

        while(i1 < size1 && i2 < size2 && i3 < size3) {
            if(a[i1] < b[i2] || a[i1] < c[i3]) i1++;
            else if(b[i2] < a[i1] || b[i2] < c[i3]) i2++;
            else if(c[i3] < a[i1] || c[i3] < b[i2]) i3++;
            else {
                if(a[i1] != prev) {
                    result.add(a[i1]);
                    prev = a[i1];
                }
                i1++;
            }
        }
        return result;
    }
}
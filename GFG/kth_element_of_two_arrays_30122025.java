package GFG;

// tc - O(n+m), sc - O(1)
class Solution {
    public int kthElement(int a[], int b[], int k) {
        int i = 0;
        int j = 0;
        int n = a.length;
        int m = b.length;

        while(k > 1){
            if(i < n && j < m){
                if(a[i] < b[j]) i++;
                else j++;
            }
            else if(i < n) i++;
            else j++;
            k--;
        }
        if(i < n && j < m){
            return Math.min(a[i], b[j]);
        }
        else if(i < n) return a[i];
        return b[j];
    }
}
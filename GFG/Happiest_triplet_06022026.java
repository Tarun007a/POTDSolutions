package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        int n = a.length;
        int i = 0;
        int j = 0;
        int k = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int minDiff = Math.max(a[0], Math.max(b[0], c[0])) - Math.min(a[0], Math.min(b[0], c[0]));
        int[] result = {a[0], b[0], c[0]};

        while(i != n-1 || j != n-1 || k != n-1){
            if(i != n-1 && j != n-1 && k != n-1){
                if(a[i] <= b[j] && a[i] < c[k]) i++;
                else if(b[j] <= a[i] && b[j] <= c[k]) j++;
                else k++;
            }
            else if(i != n-1 && j != n-1){
                if(a[i] <= b[j]) i++;
                else j++;
            }
            else if(i != n-1 && k != n-1){
                if(a[i] <= c[k]) i++;
                else k++;
            }
            else if(j != n-1 && k != n-1) {
                if(b[j] <= c[k]) j++;
                else k++;
            }
            else if(i != n-1) i++;
            else if(j != n-1) j++;
            else k++;

            int currDiff = Math.max(a[i], Math.max(b[j], c[k])) - Math.min(a[i], Math.min(b[j], c[k]));
            if(currDiff < minDiff){
                minDiff = currDiff;
                result[0] = a[i];
                result[1] = b[j];
                result[2] = c[k];
            }
            else if(currDiff == minDiff){
                if(result[0] + result[1] + result[2] == a[i] + b[j] + c[k]){
                    result[0] = a[i];
                    result[1] = b[j];
                    result[2] = c[k];
                }
            }
        }

        Arrays.sort(result);
        int temp = result[0];
        result[0] = result[2];
        result[2] = temp;
        return result;
    }
}

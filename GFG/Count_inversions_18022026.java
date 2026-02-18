package GFG;

// tc - O(nlogn), sc - O(n)
class Solution {
    private static int countInversions(int[] left, int[] right, int[] arr){
        int i = 0;
        int j = 0;
        int n1 = left.length;
        int n2 = right.length;
        int count = 0;

        while(i < n1 && j < n2){
            if(left[i] > right[j]){
                count += n1 - i;
                j++;
            }
            else i++;
        }
        return count;
    }

    private static int merge(int lo, int mid, int hi, int[] arr){
        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i++){
            left[i] = arr[i+lo];
        }

        for(int i = 0; i < n2; i++){
            right[i] = arr[i+mid+1];
        }

        int count = countInversions(left, right, arr);
        int leftIdx = 0;
        int rightIdx = 0;
        int idx = lo;

        while(leftIdx < n1 && rightIdx < n2){
            if(left[leftIdx] < right[rightIdx]) arr[idx++] = left[leftIdx++];
            else arr[idx++] = right[rightIdx++];
        }

        while(leftIdx < n1) arr[idx++] = left[leftIdx++];

        while(rightIdx < n2) arr[idx++] = right[rightIdx++];

        return count;
    }

    private static int mergeSort(int lo, int hi, int[] arr){
        if(lo >= hi) return 0;

        int mid = lo - (lo - hi) / 2;

        int left = mergeSort(lo, mid, arr);
        int right = mergeSort(mid+1, hi, arr);
        int curr = merge(lo, mid, hi, arr);

        return left + right + curr;
    }
    static int inversionCount(int arr[]) {
        int n = arr.length;
        return mergeSort(0, n-1, arr);
    }
}

package GFG;

class Solution {
    private static void reverse(int[] arr, int i, int j){
        while(i < j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        k = k%n;
        int[] arr  = new int[n];

        for(int i = 0; i < n; i++) arr[i] = dq.removeFirst();
        if(type == 1){
            reverse(arr, 0, n-k-1);
            reverse(arr, n-k, n-1);
        }
        else{
            reverse(arr, 0, k-1);
            reverse(arr, k, n-1);
        }
        reverse(arr, 0, n-1);

        for(int i : arr) dq.addLast(i);
    }
}

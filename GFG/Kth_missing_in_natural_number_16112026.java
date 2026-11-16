package GFG;

// tc - O(nlogn), sc - O(1)
class Solution {
    class Pair {
        int num;
        boolean flag;

        public Pair(int num, boolean flag) {
            this.num = num;
            this.flag = flag;
        }
    }

    private Pair getNum(int num, int[] arr) {
        int result = num;
        boolean flag = false;

        for(int ele : arr) {
            if(ele <= num) result--;
            if(ele == num) flag = true;
        }

        return new Pair(result, flag);
    }

    public int findKthSmall(int[] arr, int k) {
        int n = arr.length;

        int lo = 0;
        int hi = k + n + 1;

        while(lo <= hi) {
            int mid = hi - (hi - lo) / 2;

            Pair curr = getNum(mid, arr);

            if(curr.num == k && !curr.flag) return mid;

            if(curr.num < k) lo = mid+1;

            else hi = mid-1;
        }
        return -1;
    }
}

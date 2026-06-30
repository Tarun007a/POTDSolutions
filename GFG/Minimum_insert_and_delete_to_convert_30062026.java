package GFG;

// tc - O(nlogn), sc - O(n)
class Solution {
    private int binarySearch(int val, ArrayList<Integer> tails) {
        int st = 0;
        int end = tails.size()-1;
        int result = -1;

        while(st <= end) {
            int mid = end - (end - st) / 2;
            if(tails.get(mid) >= val) {
                result = mid;
                end = mid-1;
            }
            else {
                st = mid+1;
            }
        }
        return result;
    }

    private int lis(ArrayList<Integer> list) {
        int max = 1;
        ArrayList<Integer> tails = new ArrayList<>();
        tails.add(list.get(0));

        for(int i = 1; i < list.size(); i++) {
            int val = list.get(i);

            if(val > tails.get(max-1)) {
                tails.add(val);
                max++;
            }
            else {
                int idx = binarySearch(val, tails);
                tails.set(idx, val);
            }
        }
        return max;
    }

    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < m; i++) {
            mp.put(b[i], i);
        }

        for(int i = 0; i < n; i++) {
            int curr = a[i];
            if(mp.containsKey(curr)) {
                list.add(mp.get(curr));
            }
        }

        int lcs = lis(list);
        return n - lcs + m - lcs;
    }
}

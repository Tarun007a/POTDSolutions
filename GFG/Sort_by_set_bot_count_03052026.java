package GFG;

// tc - O(nlogn), sc - O(n)
class Solution {
    private int getSetBit(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }

    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i : arr) result.add(i);

        Collections.sort(result, (a, b) -> {
            int cnta = getSetBit(a);
            int cntb = getSetBit(b);

            return cntb - cnta;
        });

        return result;
    }
}
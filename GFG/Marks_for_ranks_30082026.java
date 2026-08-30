package GFG;

// tc - O(q * logn), sc - O(n)
class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        ArrayList<Integer> result = new ArrayList<>();
        int[] prefixSum = new int[n];

        prefixSum[0] = r[0] - l[0] + 1;

        for(int i = 1; i < n; i++) {
            prefixSum[i] += prefixSum[i-1] + r[i] - l[i] + 1;
        }

        for(int curr : rank) {
            int lo = 0;
            int hi = n-1;
            int idx = -1;

            while(lo <= hi) {
                int mid = lo - (lo - hi) / 2;

                int sum = prefixSum[mid];

                if(sum >= curr) {
                    idx = mid;
                    hi = mid-1;
                }
                else lo = mid+1;
            }
            if(idx != 0) curr -= prefixSum[idx-1];

            // System.out.println(idx + " " + curr);
            result.add(l[idx] + curr - 1);
        }
        return result;
    }
}

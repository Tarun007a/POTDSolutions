package GFG;

// tc - O(n+m), sc - O(amx(n, m))
class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int sizeA = a.length;
        int sizeB = b.length;
        int ans = 0;
        int i = 0;
        int j = 0;
        List<Integer> common = new ArrayList<>();

        while(i < sizeA && j < sizeB) {
            if(a[i] == b[j]) {
                common.add(a[i]);
                i++;
                j++;
            }
            else if(a[i] < b[j]) i++;
            else j++;
        }

        i = 0;
        j = 0;

        for(int c: common) {
            int currA = 0;
            int currB = 0;

            while(i < sizeA && a[i] != c) {
                currA += a[i];
                i++;
            }

            while(j < sizeB && b[j] != c) {
                currB += b[j];
                j++;
            }

            ans += Math.max(currA, currB);
        }

        int sumA = 0;
        while(i < sizeA) {
            sumA += a[i];
            i++;
        }

        int sumB = 0;
        while(j < sizeB) {
            sumB += b[j];
            j++;
        }

        ans += Math.max(sumA, sumB);

        return ans;
    }
}

package GFG;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[] partnerMen = new int[n];
        int[] partnerWomen = new int[n];   // woman -> man
        int[] next = new int[n];           // next woman index for each man

        Arrays.fill(partnerMen, -1);
        Arrays.fill(partnerWomen, -1);

        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();

            int w = men[m][next[m]];
            next[m]++;

            if (partnerWomen[w] == -1) {
                partnerWomen[w] = m;
                partnerMen[m] = w;
            }
            else {
                int m1 = partnerWomen[w];

                if (rank[w][m] < rank[w][m1]) {
                    partnerWomen[w] = m;
                    partnerMen[m] = w;

                    partnerMen[m1] = -1;
                    freeMen.add(m1);
                }
                else {
                    freeMen.add(m);
                }
            }
        }

        return partnerMen;
    }
}
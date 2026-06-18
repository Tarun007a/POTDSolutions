// tc - O(n*m), sc - O(1)
class Solution {
    public int findCoverage(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int totalCoverage = 0;

        for(int i = 0; i < n; i++) {
            int firstOcc = -1;
            int lastOcc = -1;

            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) {
                    lastOcc = j;
                    if(firstOcc == -1) firstOcc = j;
                }
            }

            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    if(firstOcc != -1 && j > firstOcc) totalCoverage++;
                    if(lastOcc != -1 && j < lastOcc) totalCoverage++;
                }
            }
        }

        for(int j = 0; j < m; j++) {
            int firstOcc = -1;
            int lastOcc = -1;

            for(int i = 0; i < n; i++) {
                if(mat[i][j] == 1) {
                    lastOcc = i;
                    if(firstOcc == -1) firstOcc = i;
                }
            }

            for(int i = 0; i < n; i++) {
                if(mat[i][j] == 0) {
                    if(firstOcc != -1 && i > firstOcc) totalCoverage++;
                    if(lastOcc != -1 && i < lastOcc) totalCoverage++;
                }
            }
        }
        return totalCoverage;
    }
}



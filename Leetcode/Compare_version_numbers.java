package Leetcode;

// leetcode 165
// time - O(n) and space O(1)
class Solution {
    private int getNumber(String version, int[] i){
        int n = version.length();

        StringBuilder sb = new StringBuilder();
        while(i[0] < n && version.charAt(i[0]) != '.'){
            sb.append(version.charAt(i[0]));;
            i[0]++;
        }
        return Integer.parseInt(sb.toString());
    }
    public int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();

        int[] i = new int[1];
        int[] j = new int[1];
        while(i[0] < n && j[0] < m){
            int n1 = getNumber(version1, i);
            int n2 = getNumber(version2, j);

            if(n1 < n2)return -1;
            else if(n1 > n2)return 1;
            i[0]++;
            j[0]++;
        }
        if(j[0] < m){
            while(j[0] < m){
                if(version2.charAt(j[0]) != '.' && version2.charAt(j[0]) != '0')return -1;
                j[0]++;
            }
        }
        else if(i[0] < n){
            while(i[0] < n){
                if(version1.charAt(i[0]) != '.' && version1.charAt(i[0]) != '0')return 1;
                i[0]++;
            }
        }
        return 0;
    }
}

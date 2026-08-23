package Leetcodecontest.Weekly515;

class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();

        int[] arr = new int[n];
        int j = 0;
        int max = 0;

        for(int i = 0; i < n; i++) {
            char ch = skill.charAt(i);

            while(j < m && station.charAt(j) != ch) j++;
            if(j == m) return -1;
            arr[i] = j;
            j++;
        }

        if(n == 1) return 0;
        j = m-1;
        for(int i = n-1; i > 0; i--) {
            char ch = skill.charAt(i);

            while(station.charAt(j) != ch) j--;
            arr[i] = j;
            max = Math.max(max, arr[i]-arr[i-1]);
            j--;
        }

        return max;
    }
}



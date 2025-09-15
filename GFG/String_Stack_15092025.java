package GFG;
//Time - O(n) and O(1) space
class Solution {
    public boolean stringStack(String pat, String tar) {
        int i = pat.length()-1;
        int j = tar.length()-1;

        if (j > i) return false;

        while(i>=0 && j>=0){
            if(pat.charAt(i)==tar.charAt(j)){
                i--;
                j--;
            }
            else{
                i=i-2;

            }
        }
        if(j>=0) return false;
        return true;
    }
}
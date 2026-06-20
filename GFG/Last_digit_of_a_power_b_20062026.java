// tc - O(len(b)), sc - O(1)
class Solution {
    private int modBy(int n, String s, int val) {
        int num = 0;
        for(char ch : s.toCharArray()) {
            num = num * 10 + (int)(ch-'0');
            num = num%val;
        }
        if(num == 0) num = val;

        int result = n;
        for(int i = 1; i < num; i++) {
            result *= n;
            result = result%10;
        }
        return result;
    }

    public int getLastDigit(String a, String b) {
        if(b.equals("0")) return 1;

        int n = a.length();

        int lastDigit = a.charAt(n-1) - '0';

        if(lastDigit == 1 || lastDigit == 5 ||
                lastDigit == 6 || lastDigit == 0) return lastDigit;

        if(lastDigit == 2 || lastDigit == 3 ||
                lastDigit == 7 || lastDigit == 8) return modBy(lastDigit, b, 4);

        return modBy(lastDigit, b, 2);
    }
};
package GFG;

// tc - if(n < 10) -> O(C(9, n) * n) ~ O(1), else -> O(1)
// sc - if(< 10) -> O(n), else -> O(n)

class Solution {
    private static void helper(StringBuilder num, int n, ArrayList<Integer> list) {
        if(n == 0) list.add(Integer.parseInt(num.toString()));

        int prev = 0;
        if(num.length() > 0) prev = num.charAt(num.length()-1) - '0';

        for(int i = prev+1; i <= 9; i++) {
            num.append(i);
            helper(num, n-1, list);
            num.deleteCharAt(num.length()-1);
        }
    }

    public static ArrayList<Integer> increasingNumbers(int n) {
        if(n > 9) return new ArrayList<>();
        if(n == 1) return new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        ArrayList<Integer> list = new ArrayList<>();
        helper(new StringBuilder(), n, list);
        return list;
    }
}

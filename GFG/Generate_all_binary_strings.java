package GFG;

// time complexity - O(n * (2^n))
class Solution {
    private void helper(StringBuilder sb, int n, ArrayList<String> result){
        if(n == 0){
            result.add(sb.toString());
            return;
        }

        sb.append(0);
        helper(sb, n-1, result);
        sb.deleteCharAt(sb.length()-1);

        sb.append(1);
        helper(sb, n-1, result);
        sb.deleteCharAt(sb.length()-1);

    }
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, n, result);
        return result;
    }
}

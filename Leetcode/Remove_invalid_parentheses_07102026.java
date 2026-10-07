package Leetcode;

// tc - O(2^n), sc - O(2^n)
class Solution {
    int n;
    int curr = -1;
    HashSet<String> result;

    private void update(StringBuilder sb, int removed) {
        if(curr == -1) {
            curr = removed;
            result.add(sb.toString());
            return;
        }

        if(curr > removed) {
            curr = removed;
            result.clear();
            result.add(sb.toString());
        }

        else if(curr == removed) {
            result.add(sb.toString());
        }

        // if(result.size() == 0) result.add(sb.toString());
        // else {
        //     int len = result.iterator().next().length();
        //     if(sb.length() == len)
        //     else if(sb.length() > len) {
        //         result.clear();
        //         result.add(sb.toString());
        //     }
        // }
    }

    private void helper(int i, int open, int removed, StringBuilder sb, String s) {
        if(i == n) {
            if(open != 0) return;
            update(sb, removed);
            return;
        }

        if(s.charAt(i) == '(') {
            sb.append('(');
            helper(i+1, open+1, removed, sb, s);
            sb.deleteCharAt(sb.length()-1);
        }
        else if(s.charAt(i) == ')') {
            if(open > 0) {
                sb.append(')');
                helper(i+1, open-1, removed, sb, s);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        else {
            sb.append(s.charAt(i));
            helper(i+1, open, removed, sb, s);
            sb.deleteCharAt(sb.length()-1);
        }

        if(s.charAt(i) == '(' || s.charAt(i) == ')') {
            helper(i+1, open, removed+1, sb, s);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        result = new HashSet<>();
        helper(0, 0, 0, new StringBuilder(), s);
        if(result.size() == 0) result.add("");
        return new ArrayList<>(result);
    }
}
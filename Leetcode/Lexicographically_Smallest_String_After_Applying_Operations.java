package Leetcode;

// leetcode - 1625
// time - O(n^2) space - O(n^2)
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        String result = s;

        q.offer(s);
        vis.add(s);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.compareTo(result) < 0) result = curr;

            // Operation one add a at odd indices and add
            char[] ch = curr.toCharArray();
            for (int i = 1; i < ch.length; i += 2) {
                ch[i] = (char) (((ch[i] - '0' + a) % 10) + '0');
            }
            String newStr = new String(ch);
            if (vis.add(newStr)) q.offer(newStr);

            // Operation rotate by b steps
            String rotateOp = curr.substring(n - b) + curr.substring(0, n - b);
            if (vis.add(rotateOp)) q.add(rotateOp);
        }

        return result;
    }
}
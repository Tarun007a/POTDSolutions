package GFG;
class Solution {
    public void reverseQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()) st.push(q.remove());
        while(!st.isEmpty()) q.add(st.pop());
    }
}
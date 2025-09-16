package Leetcode;
// leetcode 2197
//  the order of merging two numbers into their LCM does not matter so we can greedily
// merge elements to its left if possible, to simulate this we will use satck and recursion.
// we will efficiently find the lcm of two digits using the formula
// lcm(x,y)*gcd(x,y) = x*y as gcd works in log(Math.min(n,m)) so we can compute lcm from here.
// So one thing to remember is how to find efficienlty lcm of 2 numbers using gcd in logarithmic time
// Time, first o(n) for iteration and log(Min(n,m)) for gcd, one more thing that the in helper
// each element will get push and pop in statck only once so it will be done 2n
// TC - O(n.log(Math.min(n,m)))       SC - O(n) -> stack + rec stack
class Solution {
    private int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x%y);
    }
    private void helper(int i, Stack<Integer> st){
        if(st.isEmpty()){
            st.push(i);
            return;
        }
        int val = st.peek();
        int gcdOfNums = gcd(Math.max(val, i), Math.min(val, i));
        if(gcdOfNums == 1){
            st.push(i);
            return;
        }

        st.pop();
        int lcm = (int)((i / gcdOfNums) * (long) val);
        helper(lcm, st);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        List<Integer> result = new Stack<>();
        for(int i : nums){
            helper(i, st);
        }

        while(!st.isEmpty()) result.add(st.pop());
        Collections.reverse(result);
        return result;
    }
}
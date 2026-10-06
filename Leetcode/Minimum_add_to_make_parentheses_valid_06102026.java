package Leetcode;

// leetcode - 921
// tc & sc - O(n)
// class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> st = new Stack<>();
//         int ans = 0;
//         for(char ch : s.toCharArray()){
//             if(ch == '(')st.push(ch);
//             else if(st.isEmpty())ans++;
//             else st.pop();
//         }
//         return ans+st.size();
//     }
// }



class Solution {
    public int minAddToMakeValid(String s) {
        int result = 0;
        int count = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') count++;
            else {
                if(count == 0) result++;
                else count--;
            }
        }
        return result + count;
    }
}
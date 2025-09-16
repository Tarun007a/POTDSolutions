package GFG;
class Solution {
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> st = new Stack<>();

        for(String str : arr){
            if(str.equals("+")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1+op2);
            }
            else if(str.equals("-")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1-op2);
            }
            else if(str.equals("*")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push(op1*op2);
            }
            else if(str.equals("/")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push((int)Math.floor((double)op1/(double)op2));
            }
            else if(str.equals("^")){
                int op2 = st.pop();
                int op1 = st.pop();
                st.push((int)Math.pow(op1, op2));
            }
            else st.push(Integer.parseInt(str));
        }
        return st.pop();
    }
}
package GFG;

// tc - O(n*n), sc - O(n)
class Solution {
    public String largestSwap(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;

        for(int i  = 0; i < n-1; i++){
            int idx = -1;
            for(int j = i+1; j < n; j++){
                if(idx == -1 || ch[idx] <= ch[j]) idx = j;
            }

            if(ch[i] < ch[idx]){
                char temp = ch[i];
                ch[i] = ch[idx];
                ch[idx] = temp;
                break;
            }

        }
        return new String(ch);
    }
}

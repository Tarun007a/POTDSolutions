package Leetcode;

// leetcode - 67
// tc - O(n), sc - O(n)
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean carry = false;
        StringBuilder sb = new StringBuilder();

        while(i >= 0 && j >= 0){
            if(a.charAt(i) == '1' &&  b.charAt(j) == '1'){
                if(carry) sb.append('1');
                else{
                    carry = true;
                    sb.append('0');
                }
            }
            else if(a.charAt(i) == '1' || b.charAt(j) == '1'){
                if(carry) sb.append('0');
                else sb.append('1');
            }
            else{
                if(carry){
                    carry = false;
                    sb.append('1');
                }
                else sb.append('0');
            }
            i--;
            j--;
        }

        while(i >= 0){
            if(a.charAt(i) == '1'){
                if(carry) sb.append('0');
                else sb.append('1');
            }
            else{
                if(carry){
                    carry = false;
                    sb.append('1');
                }
                else sb.append('0');
            }
            i--;
        }

        while(j >= 0){
            if(b.charAt(j) == '1'){
                if(carry) sb.append('0');
                else sb.append('1');
            }
            else{
                if(carry){
                    carry = false;
                    sb.append('1');
                }
                else sb.append('0');
            }
            j--;
        }
        if(carry) sb.append('1');

        return sb.reverse().toString();
    }
}
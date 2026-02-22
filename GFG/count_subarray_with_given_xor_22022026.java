package GFG;

// Property or xor if a^b = c then a = b^c
// we will find running prefix xor and then the xor of any subarray is currXor ^ xorOfArrayToremove
// this way you can answer query in O(1), but firstly find prefix xor
// Now let a be xor or some elements 0 to x and b be xor of 0 to y and let x to > y
// so if we do a^b we will get xor of range x to y but here we are give what xor we want
// so now we want x and y such that a^b = k, so according to property a = b^k
// and now we just need to count how many times a have appeared previously
// just use hashmap to maintain count.
class Solution {
    public long subarrayXor(int arr[], int k) {
        int n = arr.length;
        int result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int curr = 0;

        for(int i = 0; i < n; i++){
            curr = curr ^ arr[i];
            int find = curr ^ k;

            result += mp.getOrDefault(find, 0);
            mp.put(curr, mp.getOrDefault(curr, 0)+1);
        }
        return result;
    }
}
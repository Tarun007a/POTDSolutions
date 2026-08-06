package GFG;

// tc - O(n*log(max(arr))), sc - O(1)
class Solution {
    public int countMinOperations(int arr[]) {
        int increment = 0;
        int ope2 = 0;

        for(int ele : arr) {
            int curr = 0;

            while(ele != 0) {
                if(ele%2 == 1) {
                    increment++;
                    ele--;
                }
                else{
                    ele /= 2;
                    curr++;
                }
            }
            ope2 = Math.max(ope2, curr);
        }
        return increment + ope2;

    }
}
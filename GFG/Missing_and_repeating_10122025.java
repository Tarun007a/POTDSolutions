package GFG;

// tc - O(n), sc - O(1)
class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;

        while(i < n){
            int num = arr[i];
            if(num-1 == i){
                i++;
            }
            else if(arr[num-1] == num){
                result.add(num);
                i++;
            }
            else{
                arr[i] = arr[num-1];
                arr[num-1] = num;
            }
        }

        result.add(0);

        for(i = 0; i < n; i++){
            if(arr[i] != i+1) result.set(1, i+1);
        }
        return result;
    }
}
package GFG;

// tc - O(n), sc - O(n)
class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        int result = 0;
        Queue<Integer> police = new ArrayDeque<>();
        Queue<Integer> theif = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(arr[i] == 'P'){
                while(!theif.isEmpty() && i-theif.peek() > k) theif.remove();

                if(!theif.isEmpty()){
                    result++;
                    theif.remove();
                }
                else police.add(i);
            }
            else{
                while(!police.isEmpty() && i-police.peek() > k) police.remove();

                if(!police.isEmpty()){
                    result++;
                    police.remove();
                }
                else theif.add(i);
            }
        }
        return result;
    }
}
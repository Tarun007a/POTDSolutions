package Leetcode;

// tc - O(n*n), sc - O(n)
class Solution {
    private boolean sorted(ArrayList<Integer> list){
        int size = list.size();
        for(int i = 1; i < size; i++){
            if(list.get(i-1) > list.get(i))return false;
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums)list.add(i);
        int ope = 0;

        while(!sorted(list)){
            ope++;
            int min = 1;
            for(int i = 1; i < list.size(); i++){
                if(list.get(min)+list.get(min-1) > list.get(i)+list.get(i-1))min = i;
            }
            int sum = list.get(min)+list.get(min-1);
            list.remove(min);
            list.remove(min-1);
            list.add(min-1, sum);
        }
        return ope;
    }
}

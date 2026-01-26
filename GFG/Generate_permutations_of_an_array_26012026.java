package GFG;

// tc - O(n*n!), sc - O(n)
class Solution {
    private static void generatePermutations(int n, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(n == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != -1){
                list.add(arr[i]);
                arr[i] = -1;
                generatePermutations(n-1, arr, list, result);
                arr[i] = list.get(list.size()-1);
                list.remove(list.size()-1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        generatePermutations(arr.length, arr, new ArrayList<>(), result);
        return result;
    }
}
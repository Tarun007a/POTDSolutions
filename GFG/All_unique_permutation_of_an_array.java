package GFG;

class Solution {
    private static void helper(StringBuilder sb, int[] arr, boolean[] isVisited, HashSet<String> distinct, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        // System.out.println(sb);
        boolean end = true;
        for(int i = 0; i < arr.length; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                //we add this as in case of a two digit number, what to remove a
                //single digit or 2 digit
                sb.append(arr[i] + ",");
                list.add(arr[i]);

                helper(sb, arr, isVisited, distinct, list, result);

                isVisited[i] = false;
                int removeLen = String.valueOf(arr[i]).length() + 1;
                sb.delete(sb.length() - removeLen, sb.length());
                list.remove(list.size()-1);
                end = false;
            }
        }

        if(end){
            if(distinct.add(sb.toString())){
                ArrayList<Integer> curr = new ArrayList<>(list);
                result.add(curr);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        int n = arr.length;
        boolean[] isVisited = new boolean[n];
        HashSet<String> distinct = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        helper(sb, arr, isVisited, distinct, list, result);

        Collections.sort(result, (a, b) -> {
            int len = a.size();
            int idx = 0;
            while(idx < len){
                if(a.get(idx) != b.get(idx)) return a.get(idx)-b.get(idx);
                idx++;
            }
            return 0;
        });
        return result;
    }
};




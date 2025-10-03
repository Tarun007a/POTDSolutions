package GFG;

class Solution {
    private static HashMap<Integer, List<Character>> mp = new HashMap<>();
    static{
        mp.put(2, List.of('a', 'b', 'c'));
        mp.put(3, List.of('d', 'e', 'f'));
        mp.put(4, List.of('g', 'h', 'i'));
        mp.put(5, List.of('j', 'k', 'l'));
        mp.put(6, List.of('m', 'n', 'o'));
        mp.put(7, List.of('p', 'q', 'r', 's'));
        mp.put(8, List.of('t', 'u', 'v'));
        mp.put(9, List.of('w', 'x', 'y', 'z'));
    }
    private void helper(int idx, StringBuilder sb, int[] arr, ArrayList<String> result){
        if(idx == arr.length){
            result.add(sb.toString());
            return;
        }
        if(arr[idx] == 1 || arr[idx] == 0){
            helper(idx+1, sb, arr, result);
            return;
        }

        for(char ch : mp.get(arr[idx])){
            sb.append(ch);
            helper(idx+1, sb, arr, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public ArrayList<String> possibleWords(int[] arr) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        helper(0, sb, arr, result);
        return result;
    }
}
package GFG;

// tc - O(n * n * m), sc - O(n * m)
class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for(String str : arr) {
            if(!set.contains(str)) {
                set.add(str);
                result.add(str);
            }
            else result.add("");
        }

        for(int i = 0; i < arr.length; i++) {
            String str = result.get(i);

            if(str.length() == 0) {
                int num  = 1;
                while(true) {
                    if(!set.contains(arr[i] + num)) {
                        result.set(i, arr[i] + num);
                        set.add(arr[i] + num);
                        break;
                    }
                    num++;
                }
            }
        }

        return result;
    }
}
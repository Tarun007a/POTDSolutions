package GFG;

class Solution {
    public void sortIt(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr) list.add(i);

        Collections.sort(list, (a, b) -> {
            if(a%2 == 0 && b%2 == 0) return a-b;
            if(a%2 == 1 && b %2 == 1) return b-a;
            if(a%2 == 1) return -1;
            return 1;
        });

        for(int i = 0; i < n; i++) arr[i] = list.get(i);
    }
}


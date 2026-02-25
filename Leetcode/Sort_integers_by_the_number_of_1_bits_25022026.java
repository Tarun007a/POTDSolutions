package Leetcode;

// leetcode - 1356
// tc - O(nlogn), sc - O(n)
class Solution {
    private int getCount(int n){
        int count = 0;

        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        // List<Integer> list = Arrays.stream(arr)
        //                             .mapToObj(i -> new Integer(i))
        //                             .sorted((a, b) -> {
        //                                 int count1 = getCount(a);
        //                                 int count2 = getCount(b);
        //                                 if(count1 == count2) return a - b;
        //                                 return count1 - count2;
        //                             })
        //                             .toList();
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : arr) list.add(ele);
        Collections.sort(list, (a, b) -> {
            int count1 = getCount(a);
            int count2 = getCount(b);
            if(count1 == count2) return a - b;
            return count1 - count2;
        });
        int[] result = new int[n];
        for(int i = 0; i < n; i++) result[i] = list.get(i);
        return result;
    }
}
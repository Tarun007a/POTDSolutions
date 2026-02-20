package GFG;

// tc - O(nlogn), sc - O(log(max))
class Solution {
    public String findLargest(int[] arr) {
        Comparator<String> compareNumbers = (num1, num2) ->{
            int i = 0;
            int j = 0;
            int n = num1.length();
            int m = num2.length();

            while(i < n && j < m){
                if(num1.charAt(i) != num2.charAt(j)) return num2.charAt(j) - num1.charAt(i);
                i++;
                j++;
                if(i == n && j == m) return 0;
                i = i%n;
                j = j%m;
            }
            return 0;
        };

        String result = Arrays.stream(arr)
                .mapToObj(num -> String.valueOf(num))
                .sorted(compareNumbers)
                .reduce("", (a, b) -> a+b);

        if(result.charAt(0) == '0') return "0";
        return result;
    }
}
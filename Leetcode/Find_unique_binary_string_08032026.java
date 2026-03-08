package Leetcode;

// Leetcode - 1980

// here n = 16 max which is length of array so when we go for length 16 we will try for all possbile
// 2^16 diffrent strings but as we have only 16 strings banned so when we will create 17th string of 16 it will be
// the answer at worst case so editorial say this as n^2, because we try approx n strings (precisily n+1)
// and and to generate each 16 string we so n operations insert and delete.
// class Solution {
//     private String getResult(StringBuilder sb, int n, HashSet<String> set) {
//         if(n == 0) {
//             if(set.contains(sb.toString())) return "";
//             return sb.toString();
//         }

//         sb.append('0');
//         String res1 = getResult(sb, n-1, set);
//         if(res1.length() != 0) return res1;
//         sb.deleteCharAt(sb.length()-1);

//         sb.append('1');
//         String res2 = getResult(sb, n-1, set);
//         sb.deleteCharAt(sb.length()-1);

//         return res2;
//     }
//     public String findDifferentBinaryString(String[] nums) {
//         int n = nums.length;
//         StringBuilder res = new StringBuilder();
//         HashSet<String> set = new HashSet<>();
//         for(String str : nums) set.add(str);

//         return getResult(res, n, set);
//     }
// }

//2nd approach from editorial
//We can randomly generate binary strings until we find one that is not innums. Forn = 16, there are2
//16=65536strings we could generate, and only16that would not be valid. Thus, the
//probability of finding a valid answer is 65536/65536−16 whic is over 99.9%.
// class Solution {
//     public String findDifferentBinaryString(String[] nums) {
//         Set<Integer> integers = new HashSet();
//         for (String num : nums) {
//             integers.add(Integer.parseInt(num, 2));
//         }

//         int ans = Integer.parseInt(nums[0], 2);
//         int n = nums.length;
//         Random rand = new Random();

//         while (integers.contains(ans)) {
//             ans = rand.nextInt((int) Math.pow(2, n));
//         }

//         String s = Integer.toBinaryString(ans);
//         while (s.length() < n) {
//             s = "0" + s;
//         }

//         return s;
//     }
// }

// canters algo o(n) - Editorial
// What is the point of this strategy? ans will differ from every string in at least one position. More specifically:
// ans differs from nums[0] in nums[0][0].
// ans differs from nums[1] in nums[1][1].
// ans differs from nums[2] in nums[2][2].
// ...
// ans differs from nums[n - 1] in nums[n - 1][n - 1].
// Thus, it is guaranteed that ans does not appear in nums and is a valid answer.
// Our resultant string differs from each string in nums at a particular index.
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            res.append(curr == '0' ? '1' : '0');
        }
        return res.toString();
    }
}
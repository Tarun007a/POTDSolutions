package Leetcode;

// Leetcode - 761

// It is given that the give string is special so we can iterate from start and for 1 +1 for 0 -1 and
// whenever we hit 0 it is a speical substring and definately the second part is also a special substr
// so we will try to divide the give string in as many special substring possile let s1, s2, s3, s4
// now we can only swap two adjecent specail substring so think if we want s4 at start and s2 at end
// can we do yes we can create any possible permutation we want by swapping adjcent so we will put
// the string with max 1's at start then 2nd max and so on(Just sort lexicographically), swapping
// adjecent can give us any permutation we want

// Why Recursion Is Required
/*
Consider:
This is proper like (()(()))((())) balanced paranthesis opening should be equal to closing and also
opening should always come before closing that is what the prefix condition says!

1 101100 0

Inside we had:
10 1100

We must also maximize inner blocks.
Because: If inner blocks are not maximized,
outer block won’t be maximized.
So structure is recursive.
Think like:
1 [special blocks] 0
Inside also special blocks exist.

This is like a paranthesis it should be balance i.e. same number of opening and closing brackets
also the opening must come before the closing that's what the prefix condition says so
(()(())()()) 1 means ( and 0 means ) and for this to be balance ( should come before ) and ( should
be equal to ), now we are alredy given a special string so from start if we count ( as +1 and ) as -1
so when we get 0 it is a special substring and we need to maximize the special substring to maximize the
full that's why we call rec also the structure can be nested like (()(())) so here the inner ()(())
the second part should come first but if we consider only the outer one we will never get the part
that is why we remove the first and last bracket when calling rec and we are sure that the first char
opening bracket ( and last is closing ) because for any special str
it should be a proper balanced bracket so always it will start by opening and end by closing
So recursively maximize the inner part then maximize the outer and for maximizing we will sort,
but we are only given about swaping adj but just explained at start why we can sort.
*/

// tc - O(n^2*logn), sc - O(n^2)
class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        int count = 0;
        int prev = 0;
        ArrayList<String> chunks = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1') count++;
            else count--;

            if(count == 0){
                String maximizedInnerPart = makeLargestSpecial(s.substring(prev+1, i));
                chunks.add("1" + maximizedInnerPart + "0");
                prev = i+1;
            }
        }
        Collections.sort(chunks, (a, b) -> b.compareTo(a));

        StringBuilder sb = new StringBuilder();
        for(String maximizedChunk : chunks) sb.append(maximizedChunk);
        return sb.toString();
    }
}
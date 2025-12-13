package Leetcode;

// leetcode - 3606
// tc - O(nlogn + n*m) sc - O(n)
class Solution {
    private boolean isCorrect(String str){
        return str.equals("electronics") || str.equals("grocery") || str.equals("pharmacy") || str.equals("restaurant");
    }

    private boolean isValid(String str){
        if(str.length() == 0) return false;

        for(char ch : str.toCharArray()){
            int ascii = (int)(ch);
            if(!((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122) || (ascii >= 47 && ascii <= 57) || (ch == '_'))) return false;
        }
        return true;
    }

    private int getPriority(String business){
        return switch(business){
            case "electronics" -> 1;
            case "grocery" -> 2;
            case "pharmacy" -> 3;
            case "restaurant" -> 4;
            default -> 5;
        };
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Integer> indices = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(isActive[i] && isCorrect(businessLine[i]) && isValid(code[i])){
                indices.add(i);
            }
        }

        Collections.sort(indices, (a, b) -> {

            int priorityA = getPriority(businessLine[a]);
            int priorityB = getPriority(businessLine[b]);

            if(priorityA != priorityB) return priorityA - priorityB;

            return code[a].compareTo(code[b]);
        });

        for(int i : indices) result.add(code[i]);
        return result;
    }
}
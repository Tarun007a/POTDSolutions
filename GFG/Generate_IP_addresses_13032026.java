package GFG;

// tc - O(n^3), sc - O(1)
class Solution {
    private boolean validatePart(String s) {
        if(s.length() > 3) return false;
        int num = Integer.parseInt(s);

        if (num > 0 && num < 256) {
            if(s.charAt(0) == '0') return false;
            return true;
        }
        if (num == 0) return s.length() == 1;
        return false;
    }

    private boolean isValid(int i, int j, int k, String s) {
        return (validatePart(s.substring(0, i+1)) &&  validatePart(s.substring(i+1, j+1)) && validatePart(s.substring(j+1, k+1)) && validatePart(s.substring(k+1)));
    }

    public ArrayList<String> generateIp(String s) {
        int n = s.length();
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n-1; k++) {
                    if (isValid(i, j, k, s)) {
                        result.add(s.substring(0, i+1) + "." + s.substring(i+1, j+1) + "." + s.substring(j+1, k+1) + "." + s.substring(k+1));
                    }
                }
            }
        }
        return result;
    }
}

package GFG;

class Solution {
    static String[] values = new String[1000001];

    static{
        for(int i = 1; i < values.length; i++){
            String str = Integer.toBinaryString(i);
            values[i] = str;
        }
    }
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) result.add(values[i]);
        return result;
    }
}

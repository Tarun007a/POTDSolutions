package Leetcode;

// leetcode 3484
// tc - every time we call a substring and then user parse int so len(str) passed - O(len(str))
// sc - O(row)
class Spreadsheet {
    int[][] sheet;

    private int get(String s, int st, int end){
        if(s.charAt(st) >= 65){
            int col = s.charAt(st)-'A';
            int row = Integer.parseInt(s.substring(st+1, end));
            return sheet[row][col];
        }
        else return Integer.parseInt(s.substring(st, end));
    }

    public Spreadsheet(int rows) {
        sheet = new int[rows+1][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1));
        sheet[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1));
        sheet[row][col] = 0;
    }

    public int getValue(String formula) {
        int val1 = 0;
        int val2 = 0;
        int n = formula.length();
        for(int i = 0; i < n; i++){
            if(formula.charAt(i) == '+'){
                val1 = get(formula, 1, i);
                val2 = get(formula, i+1, n);
                break;
            }
        }
        return val1+val2;
    }
}

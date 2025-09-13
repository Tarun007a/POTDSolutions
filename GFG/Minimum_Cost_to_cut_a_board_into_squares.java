package GFG;

public class Minimum_Cost_to_cut_a_board_into_squares {
    public static int minCost(int n, int m, int[] x, int[] y) {
        int result = 0;
        int hPeices = 1;
        int vPeices = 1;

        Arrays.sort(x);
        Arrays.sort(y);
        int ptr1 = x.length-1;
        int ptr2 = y.length-1;

        while(ptr1 >= 0 && ptr2 >= 0){  // vertical cut
            if(x[ptr1] > y[ptr2]){
                result += hPeices * x[ptr1];
                vPeices++;
                ptr1--;
            }
            else{                       //horizontal cut
                result += vPeices * y[ptr2];
                hPeices++;
                ptr2--;
            }
        }
        while(ptr1 >= 0){
            result += hPeices * x[ptr1];
            vPeices++;
            ptr1--;
        }
        while(ptr2 >= 0){
            result += vPeices * y[ptr2];
            hPeices++;
            ptr2--;
        }
        return result;
    }
}
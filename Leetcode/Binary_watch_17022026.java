package Leetcode;

// leetcode - 401
// tc - O(10 C K) as 10 is fix so ~ O(1), sc - O(10) ~ O(1)
// class Solution {
//     List<String> result;

//     private void convertAndAdd(int min, int hr){
//         StringBuilder sb = new StringBuilder();
//         sb.append(min);
//         if(sb.length() == 1) sb.insert(0, '0');

//         result.add(hr + ":" + sb.toString());
//     }

//     private void generateAll(int bit, boolean onMin, int min, int hr, int bits){
//         if(min >= 60 || hr >= 12) return;
//         if(bits == 0){
//             convertAndAdd(min, hr);
//             return;
//         }

//         if(onMin){
//             if(bit < 6){
//                 generateAll(bit+1, onMin, min + (int)Math.pow(2, bit), hr, bits-1);
//                 generateAll(bit+1, onMin, min, hr, bits);
//                 return;
//             }
//             else{
//                 generateAll(0, false, min, hr, bits);
//             }
//         }
//         else{
//             if(bit >= 4) return;
//             generateAll(bit+1, onMin, min, hr + (int)Math.pow(2, bit), bits-1);
//             generateAll(bit+1, onMin, min, hr, bits);
//         }
//     }
//     public List<String> readBinaryWatch(int turnedOn) {
//         result = new ArrayList<>();

//         generateAll(0, true, 0, 0, turnedOn);

//         return result;
//     }
// }

// slight optimization for finding 2 ^ n
class Solution {
    List<String> result;

    private void convertAndAdd(int min, int hr){
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        if(sb.length() == 1) sb.insert(0, '0');

        result.add(hr + ":" + sb.toString());
    }

    private void generateAll(int bit, boolean onMin, int min, int hr, int bits){
        if(min >= 60 || hr >= 12) return;
        if(bits == 0){
            convertAndAdd(min, hr);
            return;
        }

        if(onMin){
            if(bit < 6){
                generateAll(bit+1, onMin, min + (1 << bit), hr, bits-1);
                generateAll(bit+1, onMin, min, hr, bits);
                return;
            }
            else{
                generateAll(0, false, min, hr, bits);
            }
        }
        else{
            if(bit >= 4) return;
            generateAll(bit+1, onMin, min, hr + (1 << bit), bits-1);
            generateAll(bit+1, onMin, min, hr, bits);
        }
    }
    public List<String> readBinaryWatch(int turnedOn) {
        result = new ArrayList<>();
        generateAll(0, true, 0, 0, turnedOn);
        return result;
    }
}
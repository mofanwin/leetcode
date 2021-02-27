package daily_exercise.I1769;

class Solution {
    public int[] minOperations(String boxes) {
        int[] left = new int[boxes.length()+2];
        int[] right = new int[boxes.length()+2];
        int count = 0;
        for(int i = 1;i<=boxes.length();i++) {
            if(boxes.charAt(i-1) == '1') count++;
            left[i] = left[i-1] + count;
        }
        count=0;
        for(int i = boxes.length();i>0;i--){
            if(boxes.charAt(i-1) == '1') count++;
            right[i] = right[i+1]+count;
        }
        int[] result = new int[boxes.length()];
        for(int i = 1 ; i <= boxes.length();i++) {
            result[i-1] = left[i-1] + right[i+1];
        }
        return result;
    }
}
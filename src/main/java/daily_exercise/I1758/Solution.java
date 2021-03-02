package daily_exercise.I1758;

class Solution {
    public int minOperations(String s) {
        int odd = 0;
        int eve = 0;
        for(int i = 0 ; i < s.length();i++) {
            if(i % 2 == 0) {
                if(s.charAt(i) == '0') odd++;
                else eve++;
            }else {
                if(s.charAt(i) == '0') eve++;
                else odd++;
            }
        }
        return Math.min(odd, eve);
    }
}
package daily_exercise.I1759;

class Solution {
    public int countHomogenous(String s) {
        long sum = 0;
        int pre = 0;
        for(int i = 1;i<s.length();i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                long tmp = (1L + (long)(i - pre)) * (long)(i - pre) / 2L;
                sum = (sum + tmp) % 1000000007;
                pre= i;
            }
        }
        long tmp = (long)(1L + s.length()-pre) * (long)(s.length()-pre) / 2L;
        sum = (sum + tmp) % 1000000007;
        return (int) sum;
    }
}
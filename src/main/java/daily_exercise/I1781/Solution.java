package daily_exercise.I1781;

class Solution {
    public int beautySum(String s) {
        int res = 0;
        for(int l = 0; l < s.length(); l++) {
            int[] cnt = new int[26];
            for(int i = l;i<s.length();i++) {
                cnt[s.charAt(i) - 'a']++;
                res += diff(cnt);
            }
        }
        return res;
    }

    int diff(int[] cnt) {
        int min = Integer.MAX_VALUE;
        int max = 1;
        for(int i : cnt) {
            if(i > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : max - min;
    }
}
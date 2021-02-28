package daily_exercise.I1763;

class Solution {
    public String longestNiceSubstring(String s) {
        String res = "";
        for(int i = 0 ; i < s.length() ;i++) {
            for(int j = i+1;j<s.length();j++) {
                int[] tmp = new int[26];
                for(int k = i;k <=j;k++) {
                    char c = s.charAt(k);
                    if(c >='a' && c<='z') tmp[c - 'a'] |= 1;
                    if(c >='A' && c <='Z') tmp[c - 'A'] |=2;
                }
                boolean flag = true;
                for(int k = 0 ;k  < 26;k++) {
                    if(tmp[k] != 0 && tmp[k] != 3) {
                        flag = false;
                        break;
                    }
                }
                if(flag && res.length() < j-i+1) res = s.substring(i,j+1);
            }
        }
        return res;
    }
}
package daily_exercise.I1768;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        while(l < word1.length() || r < word2.length()) {
            if(l == word1.length()) {
                sb.append(word2.substring(r));
                break;
            }
            if(r == word2.length()) {
                sb.append(word1.substring(l));
                break;
            }
            if(l == r) {
                sb.append(word1.charAt(l));
                l++;
            } else {
                sb.append(word2.charAt(r));
                r++;
            }
        }
        return sb.toString();
    }
}
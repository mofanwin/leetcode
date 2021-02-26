package daily_exercise.I1771;

//"fzeuddnushxgqqmdwgmvqewsixawdzgysmvprthibufvvrqhniyvnmipdvefrao"
//"ybpg"
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int r = solution.longestPalindrome("ceebeddc", "d");
        String a = "fzeuddnushxgqqmdwgmvqewsixawdzgysmvprthibufvvrqhniyvnmipdvefrao";
        String b = "ybpg";
        int r = solution.longestPalindrome( a, b);

        System.out.println(r);
    }

    public int longestPalindrome(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        sb.append(word1).append(word2);
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        int[][] metrics = new int[str1.length()+1][str2.length()+1];
        int max = 0;
        for(int j = 1; j <= str1.length(); j++) {
            for(int i = 1; i <= str2.length(); i++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    if((i > word1.length() || j > word2.length()) && metrics[i-1][j-1] == 0) {
                        metrics[i][j] = Math.max(metrics[i][j-1], metrics[i-1][j]);
                    }else {
                        metrics[i][j] = Math.max(Math.max(metrics[i - 1][j - 1] + 1, metrics[i][j - 1]), metrics[i - 1][j]);
                    }

                    if(j > word2.length() && i > word1.length()) {
                        max = Math.max(max, metrics[i][j]);
                    }
                }else{
                    metrics[i][j] = Math.max(Math.max(metrics[i-1][j-1], metrics[i][j-1]), metrics[i-1][j]);
                }

            }
        }
        return max;
    }
}
package daily_exercise.I320;
import java.util.*;

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = generate(word, 0, true);
        res.addAll(generate(word, 0, false));
        return res;
    }

    public List<String> generate(String word, int start, boolean num) {
        List<String> result = new ArrayList<>();
        for(int i = start;i<word.length();i++) {
            String preStr = word.substring(start, i+1);
            String preNum = String.valueOf(i - start + 1);
            List<String> next = generate(word, i+1, !num);
            if(next.isEmpty()) {
                if(num) result.add(preNum);
                else result.add(preStr);
            }else {
                for(String suf : next) {
                    if(num) result.add(preNum + suf);
                    else result.add(preStr + suf);
                }
            }
        }
        return result;
    }
}
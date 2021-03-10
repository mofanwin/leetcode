package daily_exercise.I784;
import java.util.*;
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        for(char c : S.toCharArray()) {
            if(res.isEmpty()) {
                if(c >= 'a' && c <= 'z'){
                    res.add(String.valueOf(c));
                    res.add(String.valueOf((char)(c - 'a' + 'A')));
                }else if(c >='A' && c <='Z') {
                    res.add(String.valueOf(c));
                    res.add(String.valueOf((char)(c - 'A' + 'a')));
                }else {
                    res.add(String.valueOf(c));
                }
            }else {
                List<String> tmp = new ArrayList<>();
                if(c >= 'a' && c <= 'z'){
                    for(String pre : res) {
                        tmp.add(pre + c);
                        tmp.add(pre + (char)(c-'a' + 'A'));
                    }
                }else if(c >='A' && c <='Z') {
                    for(String pre : res) {
                        tmp.add(pre+c);
                        tmp.add(pre + (char)(c-'A'+'a'));
                    }
                }else {
                    for(String pre : res) {
                        tmp.add(pre+c);
                    }
                }
                res=tmp;
            }
        }
        return res;
    }
}
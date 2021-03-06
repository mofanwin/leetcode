package daily_exercise.I17;
import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {
        String[] lookup = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        for(char a : digits.toCharArray()) {
            if(result.isEmpty()) {
                for(char c : lookup[a-'2'].toCharArray()) result.add(String.valueOf(c));
            }else {
                List<String> next = new ArrayList<>();
                for(String str : result) {
                    for(char c : lookup[a-'2'].toCharArray()) {
                        next.add(str + c);
                    }

                }
                result = next;
            }
        }
        return result;

    }


}
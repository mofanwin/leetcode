package daily_exercise.I1773;
import java.util.*;
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int ruleIndex = ruleKey.equals("type") ? 0 : (ruleKey.equals("color") ? 1 : 2);
        for(List<String> item : items) {
            if(item.get(ruleIndex).equals(ruleValue)) count++;
        }
        return count;
    }
}
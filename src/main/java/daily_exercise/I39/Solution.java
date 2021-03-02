package daily_exercise.I39;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return com(candidates, target, 0, new ArrayList<>());
    }

    List<List<Integer>> com(int[] candidates, int target, int start, List<Integer> cur) {
        List<List<Integer>> result = new ArrayList<>();
        if(target == 0) result.add(new ArrayList(cur));
        for(int i = start;i < candidates.length && candidates[i] <= target;i++) {
            cur.add(candidates[i]);
            result.addAll(com(candidates, target - candidates[i], i, cur));
            cur.remove(cur.size()-1);
        }
        return result;
    }
}
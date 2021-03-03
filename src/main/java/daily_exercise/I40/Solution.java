package daily_exercise.I40;
import java.util.*;
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum2(new int[]{1,2,7,6,1,5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return com(candidates, target, 0);
    }

    private List<List<Integer>> com(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if(target == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        if(start >= candidates.length || target < 0) return result;
        int end = start;
        while(end < candidates.length && candidates[end] == candidates[start]) end++;
        result.addAll(com(candidates, target, end));
        List<Integer> cache = new ArrayList<>();
        for(int i = start ; i <end && candidates[i] <= target;i++) {
            target -= candidates[i];
            cache.add(candidates[i]);
            List<List<Integer>> tmp = com(candidates, target, end);
            for(List<Integer> l : tmp) {
                l.addAll(cache);
                result.add(l);
            }
        }
        return result;

    }
}
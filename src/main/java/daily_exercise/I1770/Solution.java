package daily_exercise.I1770;
import java.util.*;

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        return calculate(nums, multipliers, 0, nums.length-1, 0, new HashMap<>());
    }

    private int calculate(int[] nums, int[] multipliers, int l, int r, int m, Map<Integer, Map<Integer, Integer>> cache) {
        if(cache.containsKey(l) && cache.get(l).containsKey(r)) return cache.get(l).get(r);
        if(m == multipliers.length) return 0;
        int a = nums[l] * multipliers[m] + calculate(nums, multipliers, l+1, r, m+1, cache);
        int b = nums[r] * multipliers[m] + calculate(nums, multipliers, l, r-1, m+1, cache);
        Map<Integer,Integer> inner = cache.getOrDefault(l, new HashMap<>());
        inner.put(r, Math.max(a,b));
        cache.put(l, inner);
        return Math.max(a,b);
    }
}
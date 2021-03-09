package daily_exercise.I1755;
import java.util.*;
//[5,-7,3,5]
//6
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.minAbsDifference(new int[]{1,2,3}, -7);
        System.out.println(r);
    }

    public int minAbsDifference(int[] nums, int goal) {
        List<Integer> left = allCom(nums, 0, nums.length / 2);
        List<Integer> right = allCom(nums, nums.length/2, nums.length);
        TreeSet<Integer> set = new TreeSet<>();
        for(int i : left) set.add(i);
        Integer result = null;
        for(int i : right) {
            Integer tmp = diff(set, goal - i);
            if(result == null) result = tmp;
            else result = tmp == null ? result : Math.min(result, tmp);
        }
        return result;
    }

    Integer diff(TreeSet<Integer> set, int target) {
        Integer upper = set.ceiling(target);
        Integer lower = set.floor(target);
        if(upper == null) return lower == null ? null : target - lower;
        if(lower == null) return upper - target;
        return Math.min(target - lower, upper - target);
    }

    List<Integer> allCom(int[] nums, int start, int end) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = start; i < end;i++) {
            int size = list.size();
            for(int j = 0;j<size;j++) {
                list.add(list.get(j) + nums[i]);
            }
        }
        return list;
    }
}
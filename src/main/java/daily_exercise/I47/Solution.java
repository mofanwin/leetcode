package daily_exercise.I47;
import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        do {
            List<Integer> list = new ArrayList<>();
            for(int i : nums) list.add(i);
            result.add(list);
        }while(next(nums));
        return result;
    }

    private boolean next(int[] indexs) {
        int i = indexs.length-1;
        while(i > 0 && indexs[i-1] >= indexs[i]) i--;
        if(i == 0) return false;
        int j = i;
        while(j < indexs.length && indexs[j] > indexs[i-1]) j++;
        sw(indexs, i-1, j-1);
        swBetween(indexs, i, indexs.length-1);
        return true;
    }

    private void sw(int[] indexs, int l, int r) {
        int tmp = indexs[l];
        indexs[l] = indexs[r];
        indexs[r] = tmp;
    }

    private void swBetween(int[] indexs, int l, int r) {
        while(l<r) {
            sw(indexs, l, r);
            l++;
            r--;
        }
    }
}
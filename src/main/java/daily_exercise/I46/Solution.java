package daily_exercise.I46;
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] indexs = new int[nums.length];
        for(int i = 0 ; i < nums.length;i++) {
            indexs[i] = i;
        }
        List<List<Integer>> result = new ArrayList<>();
        do {
            List<Integer> list = new ArrayList<>();
            for(int i : indexs) {
                list.add(nums[i]);
            }
            result.add(list);
        }while(next(indexs));
        return result;
    }

    boolean next(int[] indexs) {
        int i = indexs.length -1;
        while( i >0) {
            if(indexs[i - 1] > indexs[i]) i--;
            else break;
        }
        if(i == 0) return false;
        int j = i;
        while(j < indexs.length) {
            if(indexs[j] > indexs[i-1]) j++;
            else break;
        }

        sw(indexs, i-1, j-1);
        swBetween(indexs, i, indexs.length-1);


        return true;
    }

    void swBetween(int[] indexs, int l, int r) {
        while(l < r) {
            sw(indexs, l, r);
            l++;
            r--;
        }
    }

    void sw(int[] indexs, int l, int r) {
        int tmp = indexs[l];
        indexs[l] = indexs[r];
        indexs[r] = tmp;
    }
}
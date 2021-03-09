package daily_exercise.I1780;
import java.util.*;

class Solution {
    public boolean checkPowersOfThree(int n) {
        List<Integer> list = new ArrayList<>();
        int base = 1;
        while(base <= n) {
            list.add(base);
            base *= 3;
        }
        return find(list,0,n);
    }

    boolean find(List<Integer> list, int start, int target) {
        if(target < 0) return false;
        if(target == 0) return true;
        if(start == list.size()) return false;
        for(int i = start;i<list.size();i++) {
            boolean tmp = find(list, i+1, target - list.get(i));
            if(tmp) return true;
        }
        return false;
    }
}
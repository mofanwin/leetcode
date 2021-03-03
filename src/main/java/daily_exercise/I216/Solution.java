package daily_exercise.I216;
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return com(k,n,1);
    }

    private List<List<Integer>> com(int k, int n, int num) {
        List<List<Integer>> result = new ArrayList<>();
        if(n == 0 && k == 0) {
            result.add(new ArrayList<>());
        }
        if(k == 0 || num > 9 || n < num) {
            return result;
        }

        List<List<Integer>> skip = com(k, n, num+1);
        result.addAll(skip);
        List<List<Integer>> use = com(k-1, n-num, num+1);
        for(List<Integer> l:use) {
            l.add(num);
            result.add(l);
        }
        return result;
    }
}
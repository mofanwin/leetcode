package daily_exercise.I254;
import java.util.*;

class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 2;i<= Math.sqrt(n);i++) {
            if(n % i == 0) {
                for(List<Integer> l : getAllFactors(n/i, i)){
                    l.add(i);
                    result.add(l);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> getAllFactors(int n, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if(n >= start) {
            List<Integer> l = new ArrayList<>();
            l.add(n);
            result.add(l);
        }
        for(int i = start;i<=Math.sqrt(n);i++) {
            if(n % i == 0) {
                List<List<Integer>> next = getAllFactors(n/i, i);
                for(List<Integer> l : next) {
                    l.add(i);
                    result.add(l);
                }
            }
        }
        return result;
    }
}
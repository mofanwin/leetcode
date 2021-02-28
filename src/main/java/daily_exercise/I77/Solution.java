package daily_exercise.I77;
import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return com(n,k,new ArrayList<>());
    }

    private List<List<Integer>> com(int n, int k, List<Integer> cur) {
        List<List<Integer>> result = new ArrayList<>();
        if(cur.size() == k) result.add(new ArrayList<>(cur));
        else {
            int start = cur.isEmpty() ? 1 : cur.get(cur.size()-1) + 1;
            for(int i = start; i<=n;i++) {
                cur.add(i);
                result.addAll(com(n, k, cur));
                cur.remove(cur.size()-1);
            }
        }
        return result;
    }
}
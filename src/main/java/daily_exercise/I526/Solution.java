package daily_exercise.I526;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countArrangement(2));
    }

    public int countArrangement(int n) {
        return verify(new boolean[n], 1, n, new HashMap());
    }

    private int verify(boolean[] visited, int index, int n, Map<Integer, Integer> cache) {
        if(index > n) return 1;
        int code = toCode(visited, index);
        if(cache.containsKey(code))
            return cache.get(code);

        int count = 0;
        for(int i=1; i<=n;i++) {
            if(!visited[i-1] && (i % index == 0 || index % i == 0)) {
                visited[i-1] = true;
                count += verify(visited, index+1, n, cache);
                visited[i-1] = false;
            }
        }
        cache.put(code, count);
        return count;
    }

    private int toCode(boolean[] visited, int index) {
        int code = index;
        for(int i = 0 ;i < visited.length; i++) {
            code<<=1;
            code += visited[i] ? 1:0;
        }
        return code;
    }

}
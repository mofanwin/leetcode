package daily_exercise.I1766;
import java.util.*;

class Solution {
    private boolean[][] dict = new boolean[51][51];

    public int[] getCoprimes(int[] nums, int[][] edges) {
        for(int i = 1;i<51;i++) {
            for(int j = 1;j<51;j++) {
                dict[i][j] = dict[j][i] = gcd(i,j);
            }
        }

        if(nums.length == 1) return new int[]{-1};
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);

            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }

        int[] result = new int[nums.length];
        dfs(null, 0, map, new Integer[51][2], nums, result, 0);
        return result;
    }

    private void dfs(Integer pre, int cur, Map<Integer, List<Integer>> map, Integer[][] visited, int[] nums, int[] result, int depth) {
        int maxDepth = -1;
        for(int test = 1;test < 51;test++) {
            if(dict[nums[cur]][test]
                    && visited[test][0] != null
                    && visited[test][0] > maxDepth) {
                maxDepth = visited[test][0];
                result[cur] = visited[test][1];
            }
        }
        if(maxDepth == -1) result[cur] = -1;

        Integer[] save = visited[nums[cur]];
        visited[nums[cur]] = new Integer[]{depth, cur};
        for(int next : map.get(cur)) {
            if(pre == null || next != pre) {
                dfs(cur, next, map, visited, nums, result, depth+1);
            }
        }
        visited[nums[cur]] = save;
    }


    private boolean gcd(int a, int b) {
        int x = Math.max(a,b);
        int y = Math.min(a,b);
        int z = x % y;
        while(z != 0) {
            x = y;
            y = z;
            z = x % y;
        }
        return y == 1;
    }
}
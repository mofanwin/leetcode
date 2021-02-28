package daily_exercise.I1761;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.minTrioDegree(17, new int[][]{{12,10},{12,16},{4,9},{4,6},{14,1},{9,2},{17,6},{17,12},{8,9},{11,14},{13,5},{8,15},{13,11},{15,11},{15,14},{6,8},{12,15},{14,12},{9,1},{9,10},{10,5},{1,11},{2,10},{15,1},{7,9},{14,2},{4,1},{17,7},{3,17},{8,1},{17,13},{10,13},{8,13},{1,7},{2,6},{13,6},{7,2},{1,16},{6,3},{6,9},{16,17},{7,14}});
        System.out.println(r);
    }

    public int minTrioDegree(int n, int[][] edges) {
        Set<Integer>[] map = new Set[n+1];
        for(int i = 1;i<=n;i++) map[i] = new HashSet<>();
        for(int[] e : edges) {
            map[e[0]].add(e[1]);
            map[e[1]].add(e[0]);
        }
        int min = Integer.MAX_VALUE;
        for(int a = 1;a<=n;a++) {
            for(int b : map[a]) {
                if(b > a) {
                    for (int c : map[b]) {
                        if (c > b && map[c].contains(a)) {
                            min = Math.min(min, map[a].size() - 2 + map[b].size() - 2 + map[c].size() - 2);
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
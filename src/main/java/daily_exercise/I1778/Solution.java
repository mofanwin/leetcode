package daily_exercise.I1778;
import java.util.*;
class Solution {
    public int findShortestPath(GridMaster master) {
        int[][] metrics = new int[1001][1001];
        mark(master, metrics, 500, 500);
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{500,500});
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int z = 0;z<size;z++) {
                int[] cur = queue.poll();
                if(metrics[cur[0]][cur[1]] == -1 || metrics[cur[0]][cur[1]] == 1) continue;
                if(metrics[cur[0]][cur[1]] == 3) return step;
                metrics[cur[0]][cur[1]] = -1;
                int[] dirs = new int[]{-1,0,1,0,-1};
                for(int i = 0;i<4;i++) {
                    int r = cur[0] + dirs[i];
                    int c = cur[1] + dirs[i+1];
                    queue.offer(new int[]{r,c});
                }
            }
            step++;
        }
        return -1;
    }

    void mark(GridMaster master, int[][] metrics, int row, int col) {
        if(metrics[row][col] != 0) return;
        if(master.isTarget()) {
            metrics[row][col] = 3;
            return;
        }
        metrics[row][col] = 2;
        int[] dirs = new int[]{-1,0,1,0,-1};
        char[] ways = new char[]{'U', 'R', 'D', 'L'};
        for(int i = 0 ; i < 4;i++) {
            if(master.canMove(ways[i])) {
                master.move(ways[i]);
                mark(master, metrics, row + dirs[i], col + dirs[i+1]);
                master.move(ways[(i+2) % 4]);
            }else {
                metrics[row + dirs[i]][col + dirs[i+1]] = 1;
            }
        }
    }
}
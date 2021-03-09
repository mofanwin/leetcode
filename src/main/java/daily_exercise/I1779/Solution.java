package daily_exercise.I1779;

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0 ; i < points.length;i++) {
            int[] p = points[i];
            if(p[0] == x || p[1] == y) {
                int dist = Math.abs(x - p[0]) + Math.abs(y - p[1]);
                if(res > dist) {
                    res = dist;
                    index = i;
                }
            }
        }
        return index;
    }
}
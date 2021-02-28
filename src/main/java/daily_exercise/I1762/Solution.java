package daily_exercise.I1762;
import java.util.*;

class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list=  new ArrayList<>();
        int h = -1;
        for(int i = heights.length-1;i>=0;i--) {
            if(heights[i] > h) {
                list.add(i);
                h = heights[i];
            }
        }
        int[] res = new int[list.size()];
        for(int i = list.size() -1;i>=0;i--) res[res.length - i - 1] = list.get(i);
        return res;
    }
}
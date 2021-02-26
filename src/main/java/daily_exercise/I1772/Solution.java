package daily_exercise.I1772;
import java.util.*;

class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> countMap = new HashMap<>();
        for(String f : features) {
            countMap.put(f, 0);
        }

        for(String res : responses) {
            String[] split = res.split(" ");
            Set<String> visited = new HashSet<>();
            for(String str : split) {
                if(countMap.containsKey(str) && !visited.contains(str)) {
                    countMap.put(str, countMap.get(str) + 1);
                    visited.add(str);
                }
            }
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1],a[1]));
        for(int i=0;i<features.length;i++) {
            heap.offer(new int[]{i, countMap.get(features[i])});
        }
        String[] result = new String[features.length];
        for(int i = 0 ; i < result.length;i++) {
            result[i] = features[heap.poll()[0]];
        }
        return result;
    }
}
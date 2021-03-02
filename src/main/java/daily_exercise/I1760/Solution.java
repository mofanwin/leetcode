package daily_exercise.I1760;

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int r = 0, l = 1;
        for(int i: nums) r = Math.max(r, i);
        while(l < r) {
            int m = (r-l)/2 + l;
            int ops = 0;
            for(int i : nums) {
                if(i <= m) continue;
                ops += (i-1) / m;
            }
            if(ops <= maxOperations) r = m-1;
            else l = m+1;
        }

        int test = 0;
        for(int i : nums) {
            if(i <= l) continue;
            test += (i-1)/ l;
        }
        if(test > maxOperations) return l+1;
        else return l;
    }
}
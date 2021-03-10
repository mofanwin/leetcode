package daily_exercise.I1785;

class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int i : nums) sum += i;
        long diff = Math.abs((long)goal - sum);
        if(diff == 0) return 0;
        long cnt = (diff-1) / limit + 1;
        return (int) cnt;
    }
}
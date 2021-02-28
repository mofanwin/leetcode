package daily_exercise.I1764;

class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int nId = 0;
        for(int i = 0 ; i < groups.length;i++) {
            int[] jump = makeJump(groups[i]);
            int k = -1;
            while(k+1 < groups[i].length) {
                if(nId >= nums.length) return false;
                if(groups[i][k+1] == nums[nId]) {
                    nId++;
                    k++;
                }else {
                    if(k == -1) {
                        nId++;
                    }else {
                        k = k == 0 ? -1:jump[k];
                    }
                }
            }
        }
        return true;
    }

    int[] makeJump(int[] nums) {
        int[] jump = new int[nums.length];
        jump[0] = -1;
        int k = -1;
        for(int i = 1;i<nums.length;i++) {
            while(k >= 0 && nums[k+1] != nums[i]) {
                k = jump[k];
            }
            if(nums[k+1] == nums[i]) k++;
            jump[i] = k;
        }
        return jump;
    }
}
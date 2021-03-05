package daily_exercise.I1775;

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if(1*nums1.length > 6*nums2.length || 6*nums1.length < 1*nums2.length) return -1;
        int[] count1 = new int[7];
        int sum1 = 0;
        int[] count2 = new int[7];
        int sum2 = 0;
        int result = 0;
        for(int i : nums1) {
            count1[i]++;
            sum1 += i;
        }
        for(int i : nums2) {
            count2[i]++;
            sum2 += i;
        }
        if(sum1 == sum2) return result;
        if(sum1 > sum2) {
            for(int i = 6;i>1;i--) {
                int diff = sum1 - sum2;
                int need = (diff-1) / (i-1) + 1;
                if(need <= count1[i] + count2[7-i]) {
                    result += need;
                    break;
                } else {
                    sum1 -= (i-1)*(count1[i] + count2[7-i]);
                    result += count1[i] + count2[7-i];
                }
            }
        }else {
            for(int i = 1;i<6;i++) {
                int diff = sum2 - sum1;
                int need = (diff-1) / (6-i) + 1;
                if(need <= count1[i] + count2[7-i]) {
                    result += need;
                    break;
                }else {
                    sum2 -= (6-i)*(count1[i] + count2[7-i]);
                    result += count1[i] + count2[7-i];
                }
            }
        }
        return result;
    }
}
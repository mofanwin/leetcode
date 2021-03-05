package daily_exercise.I1774;
import java.util.*;
class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int result = baseCosts[0];
        Set<Integer> tc = getTC(toppingCosts, 0);
        for(int b: baseCosts) {
            for(int t : tc) {
                int price = b + t;
                if(price <= target) {
                    if(Math.abs(result - target) >= target - price) result = price;
                }else {
                    if(Math.abs(result - target) > price - target) result = price;
                }
            }
        }
        return result;
    }

    private Set<Integer> getTC(int[] toppingCosts, int index) {
        Set<Integer> result = new HashSet<>();
        if(index == toppingCosts.length) {
            result.add(0);
        }else {
            Set<Integer> next = getTC(toppingCosts, index+1);
            for(int n : next) {
                result.add(n);
                result.add(toppingCosts[index]+n);
                result.add(toppingCosts[index]*2 + n);
            }
        }
        return result;
    }
}
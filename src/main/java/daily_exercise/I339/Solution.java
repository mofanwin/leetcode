package daily_exercise.I339;

import java.util.List;

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return sum(nestedList, 1);
    }

    private int sum(List<NestedInteger> nestedList, int depth) {
        int result = 0;
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                result += ni.getInteger() * depth;
            }else {
                result += sum(ni.getList(), depth+1);
            }
        }
        return result;
    }
}
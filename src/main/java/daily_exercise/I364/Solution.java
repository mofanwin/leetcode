package daily_exercise.I364;

import daily_exercise.I339.NestedInteger;

import java.util.List;

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = findMaxDepth(nestedList);
        return sum(nestedList, depth);
    }

    private int findMaxDepth(List<NestedInteger> nestedList) {
        int maxDepth = 0;
        for(NestedInteger ni : nestedList) {
            if(!ni.isInteger()){
                maxDepth = Math.max(maxDepth, findMaxDepth(ni.getList()));
            }
        }
        return maxDepth+1;
    }

    private int sum(List<NestedInteger> nestedList, int depth) {
        int result = 0;
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                result += ni.getInteger() * depth;
            }else {
                result += sum(ni.getList(), depth -1);
            }
        }
        return result;
    }
}
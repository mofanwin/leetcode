package daily_exercise.I1087;
import java.util.*;

class Solution {
    int index = 0;
    String str;
    public String[] expand(String s) {
        str = s;
        List<String> res = decode();
        String[] arrRes = new String[res.size()];
        res.toArray(arrRes);
        Arrays.sort(arrRes, (a,b) -> a.compareTo(b));
        return arrRes;
    }

    private List<String> decode() {
        List<String> result = new ArrayList<>();
        result.add("");
        StringBuilder sb = new StringBuilder();
        while(index < str.length()) {
            if(str.charAt(index) == '{') {
                index++;
                List<String> next = new ArrayList<>();
                for(String inner : result) {
                    next.add(inner + sb.toString());
                }
                result = next;

                sb = new StringBuilder();
                List<String> tmp = decode();

                next = new ArrayList<>();
                for(String a : result) {
                    for(String b: tmp) {
                        next.add(a+b);
                    }
                }
                result = next;
            }else if(str.charAt(index) == '}') {
                result.add(sb.toString());
                sb = new StringBuilder();
                index++;
                break;
            } else if(str.charAt(index) == ',') {
                result.add(sb.toString());
                sb = new StringBuilder();
                index++;
            } else {
                sb.append(str.charAt(index));
                index++;
            }
        }
        List<String> next = new ArrayList();
        for(String str: result) {
            String added = str + sb.toString();
            if(!added.isEmpty())
                next.add(added);
        }
        result = next;
        return result;
    }
}
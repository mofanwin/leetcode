package daily_exercise.I394;

class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(index < s.length()) {
            sb.append(decode(s));
        }
        return sb.toString();
    }

    private String decode(String s) {
        StringBuilder sb = new StringBuilder();
        while(index < s.length() && s.charAt(index) != ']') {
            while(index < s.length() && s.charAt(index) >= 'a' && s.charAt(index) <= 'z') {
                sb.append(s.charAt(index));
                index++;
            }
            int numStart = index;
            while(index < s.length() && s.charAt(index) >='0' && s.charAt(index) <= '9'){
                index++;
            }
            if(numStart == index) {
                break;
            }
            int multiply = Integer.parseInt(s.substring(numStart, index));
            index++;
            String innerString = decode(s);
            for(int i = 0 ; i < multiply; i++) {
                sb.append(innerString);
            }
        }
        index++;
        return sb.toString();
    }

}
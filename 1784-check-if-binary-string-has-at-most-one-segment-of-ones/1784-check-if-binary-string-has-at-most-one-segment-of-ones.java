class Solution {
    public boolean checkOnesSegment(String s) {
        int segments = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                segments++;
                while(i < s.length() && s.charAt(i) == '1') {
                    i++;
                }
            }
            if(segments > 1) {
                return false;
            }
        }
        return true;
    }
}
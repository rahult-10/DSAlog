class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        int[] lps = buildLPS(s);
        int len = lps[n-1];
        if(len > 0 && n % (n - len) == 0){
            return true;
        }
        return false;
    }

    public int[] buildLPS(String pattern){

        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while(i < m){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{

                if(len != 0)
                    len = lps[len-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
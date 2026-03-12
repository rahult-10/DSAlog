class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int length = 0;
        int i = n-1;
        while(i >= 0 && s.charAt(i) == ' '){
            i -= 1;
        }
        while(i >= 0 && s.charAt(i) != ' '){
            length += 1;
            i -= 1;
        }
        return length;
    }
}
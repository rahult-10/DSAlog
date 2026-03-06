class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < n; i++) {
            char alter1 = (i % 2 == 0) ? '0' : '1';
            char alter2 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != alter1) {
                count1++;
            }

            if(s.charAt(i) != alter2) {
                count2++;
            }
        }
        return Math.min(count1, count2);
    }
}
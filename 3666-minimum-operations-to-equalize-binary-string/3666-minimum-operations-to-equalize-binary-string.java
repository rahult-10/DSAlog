class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        
        int zeros = 0;

        for(char ch : s.toCharArray()) if(ch == '0') ++zeros;

        if(zeros == 0) return 0;
        if(k == n) return zeros == n ? 1 : -1;

        int ans = Integer.MAX_VALUE;

        if(zeros % 2 == 0){
            int m = Math.max((zeros + k - 1) / k, (zeros + n - k - 1) / (n - k));
            ans = m % 2 == 0 ? m : m + 1;
        }

        if(zeros % 2 == k % 2){
            int m = Math.max((zeros + k - 1) / k, (n - zeros + n - k - 1) / (n - k));
            m = (m % 2) != 0 ? m : m + 1;
            ans = Math.min(ans, m);
        } 


        if(ans == Integer.MAX_VALUE) return -1;

        return ans;
    }
}
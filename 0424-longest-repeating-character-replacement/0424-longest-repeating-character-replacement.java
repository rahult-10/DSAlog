class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left =0;
        int max_freq = 0;
        int max_window = 0;

        for(int right = 0; right < s.length(); right++){
            int idx = s.charAt(right) - 'A';
            freq[idx] += 1;
            max_freq = Math.max(max_freq, freq[idx]);

            int window_size = right - left + 1;
            if(window_size - max_freq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            max_window = Math.max(max_window, right - left + 1);
        }
        return max_window;
    }
}
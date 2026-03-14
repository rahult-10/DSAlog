class Solution {
    public String getHappyString(int n, int k) {
        
        int total = 3 * (1 << (n - 1));
        if (k > total){
            return "";
        }
        StringBuilder result = new StringBuilder();
        char[] chars = {'a', 'b', 'c'};
        for (int i = 0; i < n; i++) {
            for (char c : chars) {
                if (i > 0 && result.charAt(i - 1) == c){
                    continue;
                }
                int remaining = n - i - 1;
                int count = 1 << remaining;
                
                if (k > count) {
                    k -= count;
                } else {
                    result.append(c);
                    break;
                }
            }
        }

        return result.toString();
    }
}
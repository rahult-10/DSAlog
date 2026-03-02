class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < n; j += cycleLen) {
                result.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 &&
                    j + cycleLen - 2 * i < n) {
                    result.append(s.charAt(j + cycleLen - 2 * i));
                }
            }
        }
        return result.toString();
    }
}

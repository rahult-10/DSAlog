class Solution {
    public int minimumDeletions(String s) {
        char[] arr = s.toCharArray();
        int bCount = 0;
        int deletions = 0;

        for (char c : arr) {
            if (c == 'b') bCount++;
            else deletions = Math.min(deletions + 1, bCount);
        }

        return deletions;
    }
}
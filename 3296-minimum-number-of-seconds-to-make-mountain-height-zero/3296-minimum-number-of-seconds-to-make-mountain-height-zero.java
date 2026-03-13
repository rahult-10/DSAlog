class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        long left = 0, right = (long)1e18;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long totalHeight = 0;
            for (int t : workerTimes) {
                long lo = 0, hi = mountainHeight;
                while (lo < hi) {
                    long m = lo + (hi - lo + 1) / 2;
                    if (m * (m + 1) / 2 <= mid / t) lo = m;
                    else hi = m - 1;
                }
                totalHeight += lo;
            }
            if (totalHeight >= mountainHeight) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
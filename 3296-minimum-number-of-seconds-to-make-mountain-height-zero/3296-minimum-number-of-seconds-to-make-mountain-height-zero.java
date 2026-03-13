class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1, right = (long)1e18, ans = right;

        while(low <= right){
            long mid = (low + right) / 2;

            long total = 0;

            for(int x : workerTimes){
                long val = (2 * mid) / x;
                long k = (long)((Math.sqrt(1 + 4 * val) - 1) / 2);
                total += k;

                if(total >= mountainHeight) 
                    break;
            }

            if(total >= mountainHeight){
                ans = mid;
                right = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
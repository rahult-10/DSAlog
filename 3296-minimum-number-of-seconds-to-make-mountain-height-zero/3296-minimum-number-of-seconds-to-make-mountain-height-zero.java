class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a,b) -> Long.compare(a[0],b[0]));
        for(int i = 0; i < n; i++){
            pq.add(new long[]{workerTimes[i], i, 1});
        }
        long result = 0;
        while(mountainHeight > 0){
            long[] curr = pq.poll();
            long tm = curr[0];
            int id = (int)curr[1];
            int x = (int)curr[2];
            result = tm;
            mountainHeight--;

            if(mountainHeight > 0){
                long nx = x + 1;
                long nt = (long)workerTimes[id] * (nx * (nx+1)/2);
                pq.add(new long[]{nt, id, nx});
            }
        }
        return result;
    }
}
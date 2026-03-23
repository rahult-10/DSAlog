class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxProduct = new long[m][n];
        long[][] minProduct = new long[m][n];

        maxProduct[0][0] = grid[0][0];
        minProduct[0][0] = grid[0][0];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                long val = grid[i][j];

                if(i == 0){
                    maxProduct[i][j] = maxProduct[i][j-1]* val;
                    minProduct[i][j] = minProduct[i][j-1]* val;
                }
                else if(j == 0){
                    maxProduct[i][j] = maxProduct[i-1][j]* val;
                    minProduct[i][j] = minProduct[i-1][j]* val;
                } 
                else {
                    long a = maxProduct[i-1][j] * val;
                    long b = minProduct[i-1][j] * val;
                    long c = maxProduct[i][j-1] * val;
                    long d = minProduct[i][j-1] * val;

                    maxProduct[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                    minProduct[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
                }
            }
        }
        long ans = maxProduct[m-1][n-1];
        if(ans < 0) 
            return -1;

        return (int)(ans % 1_000_000_007);
    }
}
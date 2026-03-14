class Solution {

    int k;
    String result = "";
    char[] chars = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        this.k = k;
        backtrack(n, "");
        return result;
    }

    private void backtrack(int n, String s){
        if(s.length() ==  n){
            k--;
            if(k == 0){
                result = s;
            }
            return;
        }

        for(char c  : chars){
            if(s.length() == 0 || s.charAt(s.length()-1) != c){
                backtrack(n, s+c);
                if(k == 0){
                    return;
                }
            }
        }
    }
}
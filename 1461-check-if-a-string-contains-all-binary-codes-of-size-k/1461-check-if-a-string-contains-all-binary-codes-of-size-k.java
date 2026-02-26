class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count = (int)Math.pow(2,k);
        Set<String> seen = new HashSet<>();

        for(int i = 0; i <= s.length()-k; i++){
            String code = s.substring(i, i+k);
            seen.add(code);

            if(seen.size()==count){
                return true;
            }
        }
        return false;
    }
}
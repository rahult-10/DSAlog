class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        backtrack(n, "", list);
        if (k > list.size()){
            return "";
        }
        return list.get(k - 1);
    }

    private void backtrack(int n, String s, List<String> list) {
        if (s.length() == n) {
            list.add(s);
            return;
        }
        char[] chars = {'a', 'b', 'c'};

        for (char c : chars) {
            if (s.length() == 0 || s.charAt(s.length() - 1) != c) {
                backtrack(n, s + c, list);
            }

        }
    }
}
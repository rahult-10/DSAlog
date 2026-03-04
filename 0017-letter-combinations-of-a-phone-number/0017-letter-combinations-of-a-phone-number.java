class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0)
            return result;
        
        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        
        result.add("");
        
        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            String letters = phone[digit - '0'];
            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    temp.add(combination + letter);
                }
            }
            result = temp;
        }
        
        return result;
    }
}
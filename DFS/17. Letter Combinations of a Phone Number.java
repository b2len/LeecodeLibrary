class Solution {
    String[] dict = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        
        List<String> combos = new ArrayList<>();
        dfs(combos, digits.toCharArray(), "");
        return combos;
    }
    
    private void dfs (List<String> combos, char[] digits, String tempList) {
        if (tempList.length() == digits.length) {
            combos.add(tempList);
            return;
        }
        // if tempList is shorter than the digits length, continue sample the next digit
        // the first element in dict ("abc" at index 0) is corresponding to number 2
        int digit = digits[tempList.length()] - '2';        // remember this Char operation to get integer value
        for (char c: dict[digit].toCharArray()) {  
            tempList = tempList + Character.toString(c);    // remember this char to string method    
            dfs(combos, digits, tempList);
            tempList = tempList.substring(0, tempList.length() - 1);
        }
    }
}
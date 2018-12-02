class Solution {
    private String[] flatPad = {" ", "", "abc", "def", "ghi", "jkl", "mno", 
        "pqrs", "tuv", "wxyz"};

    private List<String> combine(String code, List<String> list){
        List<String> tmp = new ArrayList<>();
        char[] letters = code.toCharArray();
        for(char c : letters){
            for(String s : list){
                tmp.add(s+c);
            }
        }
        return tmp;
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null || digits.length()==0) return result;
        result.add("");
        int length = digits.length();
        for(int i = 0; i<length;i++){
            result = combine(flatPad[digits.charAt(i)-'0'], result);
        }
        return result;
    }
}

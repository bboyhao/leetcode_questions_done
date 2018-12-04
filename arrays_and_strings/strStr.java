class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if(l2==0) return 0;
        if(haystack.equals(needle)) return 0;
        for(int i=0; i<=l1-l2; i+=1){
            if(haystack.charAt(i)==needle.charAt(0) && haystack.substring(i, i+l2).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}

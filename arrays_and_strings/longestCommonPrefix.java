class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        if(strs.length==1)return strs[0];
        int min=Integer.MAX_VALUE;
        for(String s : strs){
            if(s.equals("")) return "";
            if(s.length()<min) min = s.length();
        }
        int i =0;
        while(i<min){
            char c = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(strs[j].charAt(i)!=c){
                    if(i==0) return "";
                    else return strs[0].substring(0,i);
                }
            }
            i+=1;
        }
        return strs[0].substring(0,min);
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0||s.length()==1) return s;
        String newString = insertToString(s);
        int[] RL = new int[newString.length()];
        int maxLength = 0;
        int middle = 0;
        int maxRight = 0;
        for(int j = 0; j<newString.length(); j++){
            if(j<maxRight){
                RL[j] = Math.min(maxRight-j, RL[2*middle - j]);
            }
            else{
                RL[j] = 1;
            }
            while(j-RL[j]>=0 && j+RL[j]<newString.length() &&
                    newString.charAt(j-RL[j])==newString.charAt(j+RL[j])){
                RL[j]+=1;
            }
            if(j+RL[j]-1>maxRight){
                maxRight = j+RL[j]-1;
                middle = j;
            }
            if(RL[j]>RL[maxLength]){
                maxLength = j;
            }
        }
        return newString.substring(maxLength-RL[maxLength]+1, maxLength+RL[maxLength]-1).replaceAll("#", "");
    }

    public String insertToString(String s){
        StringBuilder builder = new StringBuilder();
        builder.append("#");
        for(int i =0; i<s.length(); i++){
            builder.append(s.charAt(i));
            builder.append("#");
        }
        String newString = builder.toString();
        return newString;
    }
}

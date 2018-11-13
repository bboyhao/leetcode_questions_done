class Solution {
    public int myAtoi(String str) {
        str=str.trim();
        if(str.length()==0) return 0;
        if(str.length()==1&&!Character.isDigit(str.charAt(0))) return 0;
        if(!Character.isDigit(str.charAt(0))&&str.charAt(0)!='+'&&str.charAt(0)!='-') return 0;
        if(!Character.isDigit(str.charAt(0))&&!Character.isDigit(str.charAt(1))) return 0;
        int length = str.length();
        int i = 0;
        long result=0;
        boolean negative=false;
        boolean overflow=false;
        while(i<length){
            char c = str.charAt(i);
            if(i==0){
                if(c=='+'){i+=1;continue;}
                if(c=='-'){i+=1;negative = true;continue;}
            }
            if(!Character.isDigit(c)) break;
            if(result>result*10+Character.getNumericValue(c)){overflow=true;break;}            
            result=result*10+Character.getNumericValue(c);
            i+=1;
        }
        if(overflow){
            if(negative) return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        System.out.println(result);
        if(negative) result=0-result;
        if(result>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if(result<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return (int)result;
        
    }
}
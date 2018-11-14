class Solution {
    public int myAtoi(String str) {
      if(str==null) return 0;

      str = str.trim();
      if(str.length()==0) return 0;
      char[] array=str.toCharArray();
      int sign = 1;
      int i = 0;
      if(array[i]=='+'){sign =1;i+=1;}
      else if (array[i]=='-'){sign=-1;i+=1;}

      int result=0;
      while(i<array.length){
        int digit = array[i]-'0';
        if(digit<0||digit>9){
          return result*sign;
        }
        if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&digit>Integer.MAX_VALUE%10))
          return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        result = result*10+digit;
        i+=1;
      }
      return result*sign;
    }
}

import java.util.*;

public class WordBreak{
    public boolean wordBreak(String s, List<String> dict){
        if(s == null || s.length()==0) return false;
        int length = s.length();
        boolean[] result = new boolean[length];
        for(int i = 0; i<length; i+=1){
            for(int j = 0; j<=i; j+=1){
                String sub = s.substring(j, i+1);
                if(dict.contains(sub) && (j==0 || result[j-1])){
                    result[i] = true;
                    break;
                }
            }
        }
        return result[length-1];
    }
}

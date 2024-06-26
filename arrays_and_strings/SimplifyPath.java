import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i<path.length()){
            //System.out.println(i);
            int cur = i;
            if(path.charAt(i)!='/'){
                while(i<path.length() && path.charAt(i)!='/'){
                    i++;
                }
                String tmp = path.substring(cur, i);
                if(tmp.equals("..")){
                    if(stack.size()>0) stack.pop();
                }else if(tmp.equals(".")){
                    continue;
                }else{
                    stack.push(tmp);
                }
            }else{
                while(i<path.length() && path.charAt(i)=='/'){
                    i++;
                }
            }
        }
        String[] result = new String[stack.size()];
        for(int j=result.length-1;j>=0;j--){
            result[j] = stack.pop();
        }
        //System.out.println(Arrays.toString(result));
        return "/"+String.join("/", result);
    }
}

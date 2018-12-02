import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack st = new Stack();
        char[] array = s.toCharArray();
        for(char c : array){
            if(c=='(' || c=='[' || c=='{') st.push((Character) c);
            else if(c==')' || c==']' || c=='}'){
                if(st.isEmpty()) return false;
                Character cc = (Character) st.pop();
                if(c==')' && cc.charValue()!='(') return false;
                if(c==']' && cc.charValue()!='[') return false;
                if(c=='}' && cc.charValue()!='{') return false;
            }
        }
        return st.isEmpty();
    }
}
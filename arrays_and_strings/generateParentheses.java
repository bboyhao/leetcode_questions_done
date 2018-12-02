class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        combine(new StringBuilder(), n, 0, list);
        return list;
    }
    
    private void combine(StringBuilder sb, int a, int b, List<String> list){
        if(a==0){
            for(int i =0;i<b;i++){
                sb.append(")");
             }
            list.add(sb.toString());
        }
        else{
            combine(new StringBuilder(sb.toString()+"("), a-1, b+1, list);
            if(b!=0){
                combine(new StringBuilder(sb.toString()+")"), a, b-1, list);
            }
        }
        
        
    }
}
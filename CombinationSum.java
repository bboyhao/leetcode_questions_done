import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum{
    public List<List<Integer>> combinationSum(int[] clist, int t) {
        List<List<Integer>> res = new ArrayList<>();
        if(clist.length == 0 || clist == null){
            return res;
        }
        Arrays.sort(clist);
        List<Integer> subset = new ArrayList<>();
        helper(clist, subset, 0, t, res);
        return res;
    }
    
    private void helper(int[]clist, 
                        List<Integer> subset, 
                        int startIndex, 
                        int resSum, 
                        List<List<Integer>>res){
        if(resSum == 0){
            res.add(new ArrayList<Integer>(subset));
        }
        
        for(int i = startIndex; i < clist.length; i++){
            if(clist[i] > resSum ){
                break;
            }
            subset.add(clist[i]);
            helper(clist, subset, i, resSum-clist[i], res);
            subset.remove(subset.size()-1);
        }
    }
}

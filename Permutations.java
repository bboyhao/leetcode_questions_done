import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Permutations{
    public List<List<Integer>> permute(int[] nums) {
        // dfsPermutate will be called n! times.
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length==0 || nums == null) {
            return list;
        }
        if(nums.length == 1){
            list.add(Arrays.asList(nums[0]));
            return list;
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i<nums.length; i+=1){
            numbers.add(nums[i]);
        }
        for(int i = 0; i<numbers.size(); i+=1){
            int tmp = numbers.remove(i);
            List<Integer> cur = new ArrayList<>();
            cur.add(tmp);
            dfsPermutate(list, numbers, cur);
            numbers.add(i, tmp);
        }
        List<List<Integer>> newList = new ArrayList<>();
        for (List<Integer> l:list){
            if(!newList.contains(l)){
                newList.add(l);
            }
        }
        return newList;
    }

    public void dfsPermutate(List<List<Integer>> list, List<Integer> numbers, List<Integer> cur){
        for (int i =0;i<numbers.size();i++){
            int tmp = numbers.remove(i);
            cur.add(tmp);
            if (numbers.size() == 0){
                list.add(new ArrayList<Integer>(cur));
            }
            else{
                dfsPermutate(list, numbers, cur);
            }
            numbers.add(i, tmp);
            cur.remove(cur.size()-1);
        }
    }
    
     public List<List<Integer>> permute2(int[] array) {
        //backtrack
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> solutions = new ArrayList<>();
        permute(array, 0, new boolean[array.length], solutions, new ArrayList<>());
        return solutions;
    }

    private void permute(int[] array, int index, boolean[] used, List<List<Integer>> solutions, List<Integer> list) {
        if (index == array.length) {
            solutions.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (used[i] == false) {
                list.add(array[i]);
                used[i] = true;
                permute(array, index + 1, used, solutions, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}

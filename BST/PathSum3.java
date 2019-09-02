import java.util.*;

public class PathSum3{
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
       return dfs(map, root, sum, 0);
    }

    private int dfs(HashMap<Integer, Integer> map, TreeNode node, int target, int curSum){
        if(node == null) return 0;
        curSum += node.val;
        int count = map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0)+1);
        count += dfs(map, node.left, target, curSum);
        count += dfs(map, node.right, target, curSum);
        map.put(curSum, map.get(curSum) - 1);
        return count;
    }
}

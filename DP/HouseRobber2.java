import java.util.*;

import javax.swing.tree.TreeNode;

//Recursive solution(top down) slow due to repeat calculating the same value
public class HouseRobber{
    public int rob(TreeNode root) {
        return robRecursive(root, true);
    }

    public int robRecursive(TreeNode cur, boolean canRob){
        if(cur == null) return 0;
        int rob = 0;
        if(canRob){
            rob = cur.val + robRecursive(cur.left, false) + robRecursive(cur.right, false);
        }
        int notRob = robRecursive(cur.left, true) + robRecursive(cur.right, true);
        return Math.max(rob, notRob);
    }

    //dfs solution
    public int rob2(TreeNode root){
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode cur){
        if(cur == null) return new int[2];
        int[] left = dfs(cur.left);
        int[] right = dfs(cur.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + cur.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}


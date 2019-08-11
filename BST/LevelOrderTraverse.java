import java.util.*;

import javax.swing.tree.TreeNode;

public class LevelOrderTraverse{
    //recursive version
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        levelOrderHelper(result, root, 0);
        return result;
    }

    private void levelOrderHelper(List<List<Integer>> result, TreeNode n, int level){
        if(n == null) return;
        List<Integer> cur;
        if(level >= result.size()){
            cur = new ArrayList<>();
            cur.add(n.val);
            result.add(cur);
        }else{
            cur = result.get(level);
            cur.add(n.val);
        }
        levelOrderHelper(result, n.left, level+1);
        levelOrderHelper(result, n.right, level+1);
    }

    //iterative version
    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int qSize = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<qSize; i +=1){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left!= null){
                    q.add(cur.left);
                }
                if(cur.right!= null){
                    q.add(cur.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}

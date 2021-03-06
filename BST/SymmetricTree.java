import java.util.*;

public class SymmetricTree{
    /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) { val = x; }
    * }
    */
    //Recursive solution
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode n1, TreeNode n2){
        if( n1 == null && n2 == null) return true;
        if(n1 == null && n2 != null) return false;
        if(n2 == null && n1 != null) return false;
        return n1.val== n2.val && isMirror(n1.left, n2.right) &&
            isMirror(n1.right, n2.left);
    }

    //iterative solution
    public boolean isSymmetric2(TreeNode root){
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            if(n1 == null && n2 == null) continue; 
            if(n1 == null && n2 != null) return false;
            if(n1 != null && n2 == null) return false;
            if (n1.val != n2.val){
                return false;
            }
            q.add(n1.left);
            q.add(n2.right);
            q.add(n1.right);
            q.add(n2.left);
        }
        return true;
    }
}

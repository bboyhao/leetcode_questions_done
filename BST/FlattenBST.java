import java.util.*;

public class FlattenBST{
    //Iterative solution
    //easier to understand
    public void flatten1(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode pre = cur.left;
                while(pre.right!=null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    //Recursive solution
    TreeNode prev;
    public void flattenRec(TreeNode root) {
        bTreeToLL(root);
    }

    private void bTreeToLL(TreeNode root) {
        if (root == null)
            return;
        bTreeToLL(root.right);
        bTreeToLL(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

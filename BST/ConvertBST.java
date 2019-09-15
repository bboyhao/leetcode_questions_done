import java.util.*;

import javax.swing.tree.TreeNode;

public class ConvertBST{
    int sum = 0;
    //recursive solution;
    public TreeNode convertBST(TreeNode root){
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST2(TreeNode root){
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int sum = 0;
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}

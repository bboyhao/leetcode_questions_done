import java.util.*;

public class BuildTree{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTreeRecursive(preorder, 0, preorder.length-1, 
                inorder, 0, inorder.length - 1, map);
        return root;
    }

    private TreeNode buildTreeRecursive(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(root.val);
        int shift = index - inStart;
        root.left = buildTreeRecursive(preorder, preStart+1, preStart+shift, inorder, inStart, index-1, map);
        root.right = buildTreeRecursive(preorder, preStart+shift+1, preEnd, inorder, index +1, inEnd, map);
        return root;
    }
}

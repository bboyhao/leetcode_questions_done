public class DiameterBST{
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        ans = 0;
        traverse(root);
        return ans;
    }

    public int traverse(TreeNode node){
        if(node == null) return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        ans = Math.max(ans, left+right);
        return 1 + Math.max(left,right);
    }
}

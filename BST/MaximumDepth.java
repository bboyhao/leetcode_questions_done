public class MaximumDepth{
    public int maxDepth(TreeNode root){
        return maxDepthHelper(root, 0);
    }

    private int maxDepthHelper(TreeNode n, int depth){
        if(n == null) return depth;
        return Math.max(maxDepthHelper(n.left, depth+1), maxDepthHelper(n.right,depth+1));
    }
}

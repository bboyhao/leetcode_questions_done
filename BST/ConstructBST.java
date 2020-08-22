public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    private TreeNode helper(int[] preorder, int p1, int p2, int[] inorder, int i1, int i2, Map<Integer,Integer> map){
        if(i1 > i2 || p1 > p2) return null;
        if(i1==i2) return new TreeNode(inorder[i1]);
        int pos = map.get(preorder[p1]);
        int diff = pos-i1;
        TreeNode cur = new TreeNode(preorder[p1]);
        cur.left = helper(preorder, p1+1, p1+diff, inorder, i1, pos-1, map);
        cur.right = helper(preorder, p1+diff+1, p2, inorder, pos+1, i2, map);
        return cur;
    }
}

import java.util.*;

public class SerialisationBST{
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        res.append("[");
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append(",null");
                continue;
            }
            res.append("," + node.val);
            q.add(node.left);
            q.add(node.right);
        }
        res.deleteCharAt(1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.substring(1, data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

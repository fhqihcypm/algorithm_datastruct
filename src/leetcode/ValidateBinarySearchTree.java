package leetcode;

public class ValidateBinarySearchTree {

    public class TreeNode {
        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归在左子树中查找最小值，在右子树中查找最大值，如果最左边
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        boolean result =  helper(root, null, null);
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

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
     * 按层遍历二叉树 BFS
     * 借助队列，先当前层的结点保存起来
     * 借用两层循环，外层是层，内层是遍历当前层结点
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null ) return null;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) { //注意结束条件
            int levelSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) { //遍历当前层
                TreeNode node =  queue.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(curLevel);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = null;
        levelOrder(root);
    }
}

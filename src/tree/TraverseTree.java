package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.PriorityBlockingQueue;

public class TraverseTree {

    private static class TreeNode {
        int value;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
//                    ", leftNode=" + leftNode +
//                    ", rightNode=" + rightNode +
                    '}';
        }
    }

    //前序遍历-递归实现
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    /*****************
     * 前序遍历-循环实现
     * ***************/
    private static void preOrderNonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack stack = new Stack();
        while (true) {
            while (root != null) {//一直往一个方向走
                System.out.println(root.value);
                stack.push(root);
                root = root.leftNode;
            }
            if (stack.isEmpty()) break;
            root = (TreeNode) stack.pop(); //改变方向
            root = root.rightNode;
        }
    }

    //中序遍历-递归实现
    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftNode);
        System.out.println(root.value);
        inOrder(root.rightNode);
    }

    //中序遍历-循环实现
    private static void inOrderNonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack stack = new Stack();
        while (true) {
            //先遍历完左子树
            while (root != null) {
                stack.push(root);
                root = root.leftNode;
            }
            //左子树到头了，出栈，访问结点
            if (stack.isEmpty()) break;
            root = (TreeNode) stack.pop();
            System.out.println(root.value);
            root = root.rightNode;
        }
    }

    //后序遍历-递归实现
    private static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.leftNode);
        postOrder(node.rightNode);
        System.out.println(node.value);
    }

    //后序遍历-循环实现 ????没理解了
    private static void postOrderNonRecursive(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {

            if (node != null) {
                stack.push(node);
                node = node.leftNode;
            } else {
                if (stack.isEmpty()) return;

                if (stack.peek().rightNode == null) {
                    node = stack.pop();
                    System.out.println(node.value);
                    while (node == stack.peek().rightNode) {
                        System.out.println(stack.peek().value);
                        node = stack.pop();
                        if (stack.isEmpty()) break;
                    }
                }
                if (stack.isEmpty()) {
                    node = null;
                } else {
                    node = stack.peek().rightNode;
                }
            }
        }
    }

    //层序遍历
    private static void levelOrder(TreeNode root) {
        TreeNode tmp;
        Queue<TreeNode>  queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            System.out.println(tmp.value);
            if (tmp.leftNode != null)
                queue.offer(tmp.leftNode);
            if (tmp.rightNode != null)
                queue.offer(tmp.rightNode);
        }
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

//        preOrderNonRecursive(node1);
        levelOrder(node1);

    }
}

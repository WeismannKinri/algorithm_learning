package leetcode.explore.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> re = new ArrayList<List<Integer>>();
        if (root == null) {
            return new ArrayList<>();
        }
        // 当前层结点数
        int width = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> t = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode tem = queue.poll();
            t.add(tem.val);
            width--;
            if (tem.left != null) {
                queue.offer(tem.left);
            }
            if (tem.right != null) {
                queue.offer(tem.right);
            }
            if (width == 0) {
                re.add(t);
                //开始想的是用clear清空t，但是后来发现清空后就只有最后一层的那些数
                t = new ArrayList<Integer>();
                //一开始的时候是想着用一个变量保存下一层的宽度，然后每层遍历完了，就把下层宽度赋值给width，后来发现这个值就是queue的当前长度
                width = queue.size();
            }
        }
        return re;
    }


    /**
     * @param root 树根节点
     *             层序遍历二叉树，用队列实现，先将根节点入队列，只要队列不为空，然后出队列，并访问，接着讲访问节点的左右子树依次入队列
     */
    public static void levelTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();


        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.println(temp.val);
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        if (root == null) {
            return new ArrayList<>();
        }
        // 当前层结点数
        int width = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> t = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode tem = queue.poll();
            t.add(tem.val);
            width--;
            if (tem.left != null) {
                queue.offer(tem.left);
            }
            if (tem.right != null) {
                queue.offer(tem.right);
            }
            if (width == 0) {
                re.add(t);
                //开始想的是用clear清空t，但是后来发现清空后就只有最后一层的那些数
                t = new ArrayList<Integer>();
                //一开始的时候是想着用一个变量保存下一层的宽度，然后每层遍历完了，就把下层宽度赋值给width，后来发现这个值就是queue的当前长度
                width = queue.size();
            }
        }
        return re;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node4;
        node2.right = node5;
        List<List<Integer>> re = levelOrder(root);
        for (int i = 0; i < re.size(); i++) {
            List<Integer> tem = re.get(i);
            for (int j = 0; j < tem.size(); j++) {
                System.out.println(tem.get(j));
            }
        }
    }


    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> li = new ArrayList<Integer>();
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                li.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(li);
        }
        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

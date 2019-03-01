package leetcode.explore.binary.tree;

import java.util.LinkedList;

            public class MaxDepth {
                /**
                 * using recurtion
                 * @param root
                 * @return
                 */
                public int maxDepth(TreeNode root) {
                    if (root == null) return 0;
                    return helper(root, 1);
                }
                public int helper(TreeNode root, int i) {
                    int l = 0, r = 0;
                    if (root.left != null) {
                        l = helper(root.left, i + 1);
                    }
                    if (root.right != null) {
            r = helper(root.right, i + 1);
        }
        if (root.left == null && root.right == null) {
            return i;
        }
        return l > r ? l : r;
    }

    /**
     * using recurtion
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        int depth = 0;
        if (root != null) {
            depth = 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
        }
        return depth;
    }

    /**
     * no recurtion
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if(root == null)
            return 0;

        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int cur,last;
        int level = 0;
        while(!queue.isEmpty())
        {
            cur = 0;//记录本层已经遍历的节点个数
            last = queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
            while(cur < last)//当还没有遍历到本层最后一个节点时循环
            {
                current = queue.poll();//出队一个元素
                cur++;
                //把当前节点的左右节点入队（如果存在的话）
                if(current.left != null)
                {
                    queue.offer(current.left);
                }
                if(current.right != null)
                {
                    queue.offer(current.right);
                }
            }
            level++;//每遍历完一层level+1
        }
        return level;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
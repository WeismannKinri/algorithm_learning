package leetcode.explore.search;

public class ValidateBinarySearchTree {
    /**
     * 搜索二叉树的验证就是要求每一个子树都是满足搜索树的“左小右大”的规定，
     * 1、先判断自己作为根节点的左右二叉是否符合；
     * 2、然后返回左右节点的递归结果的 “与” （全都符合才算符合）
     * O（N*logN）
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            if (cur.val >= root.val) {
                return false;
            }
        }

        if (root.right != null) {
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            if (cur.val <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }


    /**
     * 二叉树删除算法，当删除节点有两个子节点的时候，此时会选择此节点左节点的最右子系节点，
     * 或者右节点的最左子系节点进行代替，所以这两个节点值才是最接近根节点值的节点，
     * 所以每次的单个子树判断应该判断这两个，而不是左右子节点就行了。
     * O（N）
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

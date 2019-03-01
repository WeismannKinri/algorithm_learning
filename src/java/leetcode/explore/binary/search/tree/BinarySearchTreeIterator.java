package leetcode.explore.binary.search.tree;

import java.util.Stack;

public class BinarySearchTreeIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = stack.pop();
        TreeNode current = next.right;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        return next.val;
    }
}

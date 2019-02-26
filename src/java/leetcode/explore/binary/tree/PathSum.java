package leetcode.explore.binary.tree;

import java.util.Stack;

public class PathSum {
    /**
     * using recurtion, mine
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        Stack<Integer> stack = new Stack();
        helper(root,0,sum,stack);
        return !stack.isEmpty();
    }
    public void helper(TreeNode root, int sum, int targetSum, Stack<Integer> stack){
        if(root!=null){
            sum+=root.val;
            helper(root.left, sum, targetSum, stack);
            helper(root.right, sum, targetSum, stack);
            if(root.left==null && root.right==null && sum==targetSum){
                stack.push(1);
            }
            sum-=root.val;
        }
    }
}

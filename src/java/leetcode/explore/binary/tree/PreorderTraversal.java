package leetcode.explore.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    /**
     * use stack
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode tr = stack.pop();

            if(tr!=null){
                list.add(tr.val);
            }

            if(tr.right!=null){
                stack.push(tr.right);
            }

            if(tr.left!=null){
                stack.push(tr.left);
            }
        }
        return list;
    }

    /**
     * use recurtion
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalRecurtion(TreeNode root) {
        List<Integer> list = new LinkedList();
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode root,List<Integer> list){
        if(root!=null){
            list.add(root.val);
            preorder(root.left,list);
            preorder(root.right,list);
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

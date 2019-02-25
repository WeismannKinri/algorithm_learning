package leetcode.explore.binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {


    // Using recurtion
    public void helper(TreeNode root, ArrayList<Integer> re){
        if(root==null)
            return;
        helper(root.left,re);
        re.add(root.val);
        helper(root.right,re);
    }
    public ArrayList<Integer> inorderTraversalByRecurtion(TreeNode root) {
        ArrayList<Integer> re = new ArrayList<Integer>();
        if(root==null)
            return re;
        helper(root,re);
        return re;
    }

    //No Recurtion
    public List<Integer> inorderTraversalNoRecurtion(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        if(root==null){
            return list;
        }

        TreeNode p = root;
        stack.push(root);

        while(!stack.isEmpty()){
            if(p!=null && p.left!=null){
                stack.push(p.left);
                p=p.left;
            } else{
                p = stack.pop();
                list.add(p.val);
                if(p!=null && p.right != null){
                    stack.push(p.right);
                    p=p.right;
                }else{
                    p=null;
                }

            }

        }

        return list;
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

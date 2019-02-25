package leetcode.explore.search.tree;

import java.util.ArrayList;
import java.util.LinkedList;

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
    public ArrayList<Integer> inorderTraversalNoRecurtion(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

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
                if(p != null && p.right != null){
                    stack.push(p.right);
                    p=p.right;
                }else{
                    p=null;
                }
            }
        }

        return list;
    }



    /**
     *
     * @param root 树根节点
     * 利用栈模拟递归过程实现循环中序遍历二叉树
     * 思想和上面的preOrderStack_2相同，只是访问的时间是在左子树都处理完直到null的时候出栈并访问。
     */
    public static void inOrderStack(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> s=new Stack<TreeNode>();
        while(root!=null||!s.isEmpty()){
            while(root!=null){
                s.push(root);//先访问再入栈
                root=root.left;
            }
            root=s.pop();
            System.out.println(root.val);
            root=root.right;//如果是null，出栈并处理右子树
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

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



    /**
     *
     * @param root 树根节点
     * 利用栈实现循环先序遍历二叉树
     * 这种实现类似于图的深度优先遍历（DFS）
     * 维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。
     * 这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用
     */
    public static void preOrderStack_1(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            System.out.println(temp.val);
            if(temp.right!=null) s.push(temp.right);
            if(temp.left!=null) s.push(temp.left);
        }
    }
    /**
     *
     * @param root 树的根节点
     * 利用栈模拟递归过程实现循环先序遍历二叉树
     * 这种方式具备扩展性，它模拟递归的过程，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树
     */
    public static void preOrderStack_2(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> s=new Stack<TreeNode>();
        while(root!=null||!s.isEmpty()){
            while(root!=null){
                System.out.println(root.val);
                s.push(root);//先访问再入栈
                root=root.left;
            }
            root=s.pop();
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

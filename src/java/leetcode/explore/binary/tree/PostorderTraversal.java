package leetcode.explore.binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();

        if(root ==null){
            return list;
        }

        Stack<TreeNode> stack =new Stack<TreeNode>();
        TreeNode proot;//标记栈顶元素前一个被访问的元素
        int flag;//root的左孩子未被访问；
        if(root!=null){
            do{
                while(root!=null){//将root所有左孩子全部入栈
                    stack.push(root);
                    root=root.left;
                }

                //执行到此处，栈顶元素没有左孩子或者左子树已经被访问过；
                proot=null;//标记栈顶元素前一个被访问的元素，或者此时为最左下边，该元素前一个被访问的元素肯定为空。
                flag=1;//root的左孩子已经被访问；或者root为null

                while(!stack.isEmpty() && flag==1){
                    root=stack.peek();       //取到栈顶元素，但是不出栈；
                    if(root.right==proot){
                        root=stack.pop();
                        list.add(root.val);
                        proot=root;
                    }else{
                        root=root.right;
                        flag=0;//root左边孩子未被访问；
                    }
                }
            }while(!stack.isEmpty());
        }
        return list;
    }


    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right=right;
        right.left=left;

        postorderTraversal.postorderTraversal(root);
        return;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

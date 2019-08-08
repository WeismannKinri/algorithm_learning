package leetcode.explore.binary.tree;

import java.util.*;

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


    public String reverseWords1(String s) {
        int storeIndex = 0, n = s.length();
        StringBuilder sb = new StringBuilder(s).reverse();
        for (int i = 0; i < n; ++i) {
            if (sb.charAt(i) != ' ') {
                if (storeIndex != 0) sb.setCharAt(storeIndex++, ' ');
                int j = i;
                while (j < n && sb.charAt(j) != ' ') sb.setCharAt(storeIndex++, sb.charAt(j++));
                String t = new StringBuilder(sb.substring(storeIndex - (j - i), storeIndex)).reverse().toString();
                sb.replace(storeIndex - (j - i), storeIndex, t);
                i = j;
            }
        }
        sb.setLength(storeIndex);
        return sb.toString();
    }


    public void moveZeroes(int[] nums) {
        if (nums==null)
            return;
        int slow=0;
        for (int i = 0; i< nums.length;i++){
            if(nums[i]==0){
                nums[slow++] = nums[i];
            }
        }
        for(int i = slow; i<nums.length;i++){
            nums[i]=0;
        }
    }


    public static ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)return null;
        if(head.next==head)return head;
        ListNode l=head.next;
        head.next=head;
        return detectCycle(l);
    }


    public static void main(String[] args) {
        System.out.println(0^0);
    }

//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(3);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(0);
//        ListNode l4 = new ListNode(-4);
//
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l2;
//        System.out.println(detectCycle(l1).val);
//    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i< 32 ;i++){
            int temp = n & 1;
            n = n >> 1;
            result = (result<<1)|temp;
        }
        return result;
    }



}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
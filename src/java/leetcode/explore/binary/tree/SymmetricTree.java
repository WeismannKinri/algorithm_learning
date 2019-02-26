package leetcode.explore.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    /**
     * using recurtion
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetrical(root,root);
    }

    boolean isSymmetrical(TreeNode pRootl,TreeNode pRootr){

        if(pRootl==null && pRootr==null){
            return true;
        }
        if(pRootl==null || pRootr==null){
            return false;
        }
        if(pRootl.val!=pRootr.val){
            return false;
        }
        return isSymmetrical(pRootl.left,pRootr.right) && isSymmetrical(pRootl.right,pRootr.left);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode rootl = new TreeNode(2);
        TreeNode rootr = new TreeNode(2);
        root.left=rootl;
        root.right=rootr;

        TreeNode rootlr = new TreeNode(3);
        TreeNode rootrr = new TreeNode(3);

        rootl.right=rootlr;
        rootrr.right=rootrr;
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(root));


        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

    }

}



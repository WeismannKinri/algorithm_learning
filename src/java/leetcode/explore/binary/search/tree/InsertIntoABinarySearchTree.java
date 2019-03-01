package leetcode.explore.binary.search.tree;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode treeNode = new TreeNode(val);
        if(root==null){
            return treeNode;
        }
        helper(root,val);
        return root;
    }

    public void helper(TreeNode root, int val){
        if(root.val==val){
            return ;
        } else if(root.val>val){
            if(root.left==null){
                TreeNode treeNode = new TreeNode(val);
                root.left=treeNode;
                return ;
            }else{
                insertIntoBST(root.left, val);
            }
        } else {
            if(root.right==null){
                TreeNode treeNode = new TreeNode(val);
                root.right=treeNode;
                return;
            }else{
                insertIntoBST(root.right, val);
            }
        }
    }
}

package leetcode.explore.binary.search.tree;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val>val){
            if(root.left==null){
                return null;
            }else{
                return searchBST(root.left, val);
            }
        } else if(root.val<val){
            if(root.right==null){
                return null;
            }else{
                return searchBST(root.right, val);
            }
        } else {
            return root;
        }
    }
}

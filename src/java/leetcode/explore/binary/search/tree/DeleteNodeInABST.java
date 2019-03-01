package leetcode.explore.binary.search.tree;

public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        //require
        if (root == null)
            return root;
        //invariant
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        else {
            //two children
            if (root.left != null && root.right != null) {
                TreeNode tmp = findMin(root.right);
                root.val = tmp.val;
                root.right = deleteNode(root.right, root.val);
            } else {
                //one child or zero
                if (root.left == null)
                    root = root.right;
                else
                    root = root.left;
            }
        }
        //ensure
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
}

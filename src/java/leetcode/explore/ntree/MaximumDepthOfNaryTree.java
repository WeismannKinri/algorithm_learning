package leetcode.explore.ntree;

public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        return helper(root);
    }

    public int helper(Node root){
        int depth=0;
        int tmp = 0;
        if(root!=null && root.children!=null){
            depth=1;
            for(int i = 0; i<root.children.size(); i++){
                tmp = 1+helper(root.children.get(i));
                depth=depth<tmp?tmp:depth;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(1%2);
    }
}
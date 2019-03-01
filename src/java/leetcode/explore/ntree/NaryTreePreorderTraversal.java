package leetcode.explore.ntree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        helper(root, list);
        return list;
    }

    public void helper(Node root, List<Integer> list) {
        if(root==null || root.children==null)
            return;
        list.add(root.val);
        for(int i = 0; i<root.children.size();i++){
            helper(root.children.get(i),list);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

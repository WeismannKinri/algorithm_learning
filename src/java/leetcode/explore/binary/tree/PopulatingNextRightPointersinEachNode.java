package leetcode.explore.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    /**
     * 因为是完美二叉树，如果有左子树，一定有右子树。我们将结点的左子树和右子树相连。
     * 如果结点next不为空，那么将结点右子树指向结点next的左子树。
     * using recurtion
     *
     * @param root
     */
    public void connect(Node root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    /**
     * using level-traversal
     *
     * @param root
     */
    public void connect2(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.peek();
                q.poll();
                if (i < size - 1) temp.next = q.peek();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
    }

    /**
     * 利用层指针和深度的指针
     *
     * @param root
     */
    public void connect3(Node root) {
        if (root == null) return;
        Node cur = null, start = root;
        while (start.left != null) {
            cur = start;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            start = start.left;           //这个地方是left,不是next
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node next;
}
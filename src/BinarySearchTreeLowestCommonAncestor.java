class Node1
{        int data;
        Node1 left;
        Node1 right;
}

public class BinarySearchTreeLowestCommonAncestor {

    public static Node1 lca(Node1 root, int v1, int v2) {
        // Write your code here.
        if (root == null) {
            return root;
        }

        Node1 left = lca(root.left, v1, v2);
        Node1 right = lca(root.right, v1, v2);

        if (left != null && right != null) {
            return root;
        } else if (left != null && root.data == v1 || root.data == v2) {
            return root;
        } else if (right != null && root.data == v1 || root.data == v2) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            if (root != null && root.data == v1 || root.data == v2) {
                return root;
            } else {
                return null;
            }
        }
    }
}
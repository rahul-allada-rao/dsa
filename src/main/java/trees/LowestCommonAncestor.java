package trees;

import trees.TreeNode;

/**
 * **Example:**
 * ```
 *         3
 *        / \
 *       5   1
 *      / \ / \
 *     6  2 0  8
 *       / \
 *      7   4
 *
 * LCA(6, 4) = 5
 * LCA(5, 1) = 3
 * LCA(6, 7) = 5
 * ```
 *
 * ---
 *
 * ## 📋 Definition
 * The **Lowest Common Ancestor** of two nodes p and q is the **deepest node** that has both p and q as descendants (a node can be a descendant of itself).
 *
 * ---
 *
 * ## 📋 Requirements
 * - Return the `TreeNode` that is the LCA
 * - Both p and q are guaranteed to exist in the tree
 * - Handle null root → return null
 * - O(n) time 🎯
 *
 * ---
 *
 * ## 💡 Hint
 *
 * Think recursively. At any node, three situations:
 * ```
 * 1. Current node IS p or q → return current node
 * 2. p is in left subtree, q is in right subtree → current node is LCA
 * 3. Both p and q are in same subtree → recurse into that subtree
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    private static TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if (root == null)
            return root;

        if (root == p || root == q)
            return root;

        TreeNode leftRoot = findLowestCommonAncestor(root.left, p, q);
        TreeNode rightRoot = findLowestCommonAncestor(root.right, p, q);

        if (leftRoot != null && rightRoot != null)
            return root;

        return leftRoot != null ? leftRoot : rightRoot;
    }

    private static TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val)
            return lcaBST(root.left, p, q);  // both left

        if (p.val > root.val && q.val > root.val)
            return lcaBST(root.right, p, q); // both right

        return root; // split point → LCA found
    }
}

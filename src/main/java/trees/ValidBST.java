package trees;

public class ValidBST {

    /**
     * **Example:**
     * ```
     * Valid BST:          Invalid BST:
     *       5                   5
     *      / \                 / \
     *     3   7               3   7
     *    / \ / \             / \ / \
     *   2  4 6  8           2  6 4  8
     *                             ↑
     *                         6 > 5 but is in left subtree of 7
     *                         violates BST property
     * ```
     * @param root
     * @return
     */
    private static boolean checkBST(TreeNode root){
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, Integer min, Integer max){
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max) return false;


        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

    }
}

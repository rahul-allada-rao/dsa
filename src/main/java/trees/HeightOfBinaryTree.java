package trees;

public class HeightOfBinaryTree {
    public static void main(String[] args) {

    }

    /**
     *          1
     *        / \
     *       2   3
     *      / \
     *     4   5
     *
     * Height = 3 (longest path from root to leaf)
     * @param root
     * @return
     */
    private static int findHeightOfBinaryTree(TreeNode root){
        // base case
        if (root == null) return 0;

        // process and recursion
        return 1 + Math.max(findHeightOfBinaryTree(root.left), findHeightOfBinaryTree(root.right));
    }
}

package trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * **Example:**
 * ```
 *         1
 *        / \
 *       2   3
 *      / \   \
 *     4   5   6
 *
 * Left View:  [1, 2, 4]  (first node of each level)
 * Right View: [1, 3, 6]  (last node of each level)
 * ```
 */
public class LeftView {

    private static List<Integer> leftView(TreeNode root){
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offer(root);

        List<Integer> leftTreeIntegers = new ArrayList<>();
        while (!treeQueue.isEmpty()){

            int sizeOfLevel = treeQueue.size();

            for (int i=0; i<sizeOfLevel; i++){
                TreeNode currentNode = treeQueue.poll();
                if (currentNode != null){
                    if (i == 0)
                        leftTreeIntegers.add(currentNode.val);

                    if (currentNode.left != null)
                        treeQueue.offer(currentNode.left);

                    if (currentNode.right != null)
                        treeQueue.offer(currentNode.right);
                }
            }

        }
        return leftTreeIntegers;
    }

    private static List<Integer> rightView(TreeNode root){
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offer(root);

        List<Integer> rightTreeIntegers = new ArrayList<>();
        while (!treeQueue.isEmpty()){
            int sizeOfLevel = treeQueue.size() - 1;
            for (int i=0; i < sizeOfLevel; i++){
                TreeNode currentNode = treeQueue.poll();
                if (currentNode != null){
                    if (i == 0)
                        rightTreeIntegers.add(currentNode.val);

                    if (currentNode.left != null)
                        treeQueue.offer(currentNode.left);

                    if (currentNode.right != null)
                        treeQueue.offer(currentNode.right);
                }
            }
        }
        return rightTreeIntegers;
    }
}
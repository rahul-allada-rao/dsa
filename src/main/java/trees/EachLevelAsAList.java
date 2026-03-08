package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EachLevelAsAList {
    public static void main(String[] args) {

    }

    /**
     *          1
     *        / \
     *       2   3
     *      / \   \
     *     4   5   6
     *
     * Output: [[1], [2, 3], [4, 5, 6]]
     * (each level as a separate list)
     * @param root
     * @return
     */
    private static List<List<Integer>> eachLevelAsAList(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()){

            int sizeOfLevel = treeNodeQueue.size();
            List<Integer> localList = new ArrayList<>();

            for (int i=0; i<sizeOfLevel; i++){
                TreeNode node = treeNodeQueue.poll();
                localList.add(node.val);
                if (node.left != null) treeNodeQueue.offer(node.left);
                if (node.right != null) treeNodeQueue.offer(node.right);
            }
            result.add(localList);
        }
        return result;
    }
}

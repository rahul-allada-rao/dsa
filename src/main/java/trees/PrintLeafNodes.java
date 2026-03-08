package trees;


import java.util.ArrayList;
import java.util.List;

public class PrintLeafNodes {
    public static void main(String[] args) {

    }

    private static List<Integer> printLeafNodes(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        printLeafNodesHelper(treeNode, list);
        return list;
    }

    private static void printLeafNodesHelper(TreeNode treeNode, List<Integer> list){
        // base case
        if (treeNode == null) return;

        // if both left and right of the current node is empty, then it's a leaf node, print its value
        if (treeNode.left == null && treeNode.right == null){
            list.add(treeNode.val);
            return;
        }
        // recursive call
        printLeafNodesHelper(treeNode.left, list);
        printLeafNodesHelper(treeNode.right, list);
    }
}

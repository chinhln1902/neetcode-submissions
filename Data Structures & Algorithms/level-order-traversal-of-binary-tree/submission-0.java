/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        queue.add(root);
        List<Integer> tempArr = new ArrayList<>();
        tempArr.add(root.val);
        result.add(tempArr);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempArray = new ArrayList<>();

            while (size > 0) {
                TreeNode currentNode = queue.poll();
                if (currentNode != null) {
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                        tempArray.add(currentNode.left.val);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                        tempArray.add(currentNode.right.val);
                    }
                }
                size--;
            }
            if (!tempArray.isEmpty()) {
                result.add(tempArray);
            }
        }
        return result;
    }
}

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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode root, int maxNode) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        if (root.val >= maxNode) {
            result++;
        }

        return result 
        + countGoodNodes(root.left, Math.max(root.val, maxNode)) 
        + countGoodNodes(root.right, Math.max(root.val, maxNode));
    }
}

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
    public boolean isValidBST(TreeNode root) {
        return checkSubTrees(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkSubTrees(TreeNode root, int minNode, int maxNode) {
        if (root == null) {
            return true;
        }
        if (root.val <= minNode || root.val >= maxNode) {
            return false;
        }

        return checkSubTrees(root.left, minNode, root.val) 
        && checkSubTrees(root.right, root.val, maxNode);
    }
}

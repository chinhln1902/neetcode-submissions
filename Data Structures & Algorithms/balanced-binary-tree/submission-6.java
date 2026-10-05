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
    public boolean isBalanced(TreeNode root) {
        if (calculateHeight(root) != -1) {
            return true;
        }
        return false;
    }

    public int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = calculateHeight(node.left); //Calculate height of left node
        int right = calculateHeight(node.right); //Calculate height of right node

        if (left == -1) { //If subtree of left node is unbalance, return -1
            return -1;
        }

        if (right == -1) { //If subtree of right node is unbalance, return -1
            return -1;
        }

        if (Math.abs(left - right) > 1) { //If the different between left and right subtree more than 1 which means unbalance, return -1
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}

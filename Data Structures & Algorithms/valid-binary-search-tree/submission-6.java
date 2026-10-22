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
        //If the current node not in the range of minNode and maxNode => not valid BST
        if (root.val <= minNode || root.val >= maxNode) {
            return false;
        }

        return checkSubTrees(root.left, minNode, root.val) //Since left node must be smaller than its parent, hence we update maxNode = root.val
        && checkSubTrees(root.right, root.val, maxNode); //Since right node must be larger than its parent, hence we update minNode = root.val
    }
}

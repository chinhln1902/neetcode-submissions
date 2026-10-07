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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return scanTrees(p, q);
    }

    public boolean scanTrees(TreeNode nodeP, TreeNode nodeQ) {
        //Make sure trees have same structure
        if (nodeP == null && nodeQ == null) {
            return true;
        }

        if (nodeP == null || nodeQ == null) {
            return false;
        }
        boolean compareLeft = scanTrees(nodeP.left, nodeQ.left);
        boolean compareRight = scanTrees(nodeP.right, nodeQ.right);
        return nodeP.val == nodeQ.val && compareLeft && compareRight;
    }

}

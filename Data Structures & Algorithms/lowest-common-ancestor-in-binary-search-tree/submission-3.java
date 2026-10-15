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
 // In Binary search tree, left node always less than parent node and right node always larger than parent node.
 /* The idea is iterate through each node:
  - If current "root" node less than right node (q) and larger than left node (p) -> means p and q are splitted hence current "root" is LCA, return it
  - If current "root" node equals to p -> means the LCA is current node, return it
  - If current "root" node equals to q -> means the LCA is current node, return it
  - If current "root" less than both p and q -> means p and q are in left side of current "root" hence dive deeper to the left
  - If current "root" larger than both p and q -> means p and q are in right side of current "root" hence dive depper to the right
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root, p, q);
    }

    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val > root.val) {
            return root;
        }
        if (root.val == p.val) {
            return root;
        }
        if (root.val == q.val) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return findLCA(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return findLCA(root.right, p, q);
        }
        return root;
    }
}   
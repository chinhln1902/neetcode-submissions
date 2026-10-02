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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return root;
    }
}

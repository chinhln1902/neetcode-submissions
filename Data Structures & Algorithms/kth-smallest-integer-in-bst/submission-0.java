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
    int count = 0;
    List<Integer> array = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return array.get(k - 1);
    }

    public void inOrderTraversal(TreeNode root, int k) {
        if (root != null) {
        inOrderTraversal(root.left, k);
        array.add(root.val);
        inOrderTraversal(root.right, k);
        }
    }
}

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false; 
        }

        //Check if the tree "root" and tree "subRoot" are exactly the same from the beginning
        if (isSameTree(root, subRoot)) {
            return true;
        }

        //Start traversing to each node of "root" tree and comparing to "subRoot" node
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //This method start comparing the sub tree of root starting from node "node" and subRoot to see if they are exactly the same.
    private boolean isSameTree(TreeNode node, TreeNode subRoot) {
        //If node "node" and "subRoot" reaches the end, meaning both trees are the same, return true
        if (node == null && subRoot == null) {
            return true;
        }

        //This means if the structure of both trees are different
        if (node == null || subRoot == null) {
            return false;
        }

        //This means if value of both nodes are different
        if (node.val != subRoot.val) {
            return false;
        }

        //If the code reaches here, that means the node "node" and "subRoot" are the same value, proceed to left and right node.
        return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
    }
}

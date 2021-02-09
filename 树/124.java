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
    int res = -Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        inner(root);
        return res;
    }

    public int inner(TreeNode root) {
        if(root==null) return -40000000;
        int a1 = inner(root.left);
        int a2 = inner(root.right);
        res = Math.max(Math.max(Math.max(a1, a2), Math.max(a1+a2,0)) + root.val, res);
        return Math.max(0, Math.max(a1, a2)) + root.val;
    }
}
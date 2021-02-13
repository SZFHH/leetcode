/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] rv = inner(root);
        return Math.max(rv[0], rv[1]);
    }

    public int[] inner(TreeNode node) {
        if(node==null) {
            return new int[]{0, 0};
        }
        int[] left = inner(node.left);
        int[] right = inner(node.right);
        int[] rv = new int[2];
        rv[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        rv[1] = left[0] + right[0] + node.val;
        return rv;
    }
}
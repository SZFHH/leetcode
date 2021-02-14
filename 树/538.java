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
    public TreeNode convertBST(TreeNode root) {
        dfs2(root, dfs1(root), new int[]{0});
        return root;
    }

    public int dfs1(TreeNode node) {
        if(node==null) return 0;
        return dfs1(node.left) + dfs1(node.right) + node.val;
    }

    public void dfs2(TreeNode node, int sum, int[] cur) {
        if(node==null) return;
        dfs2(node.left,sum, cur);
        int tmp = node.val;
        node.val = sum-cur[0];
        cur[0] += tmp;
        dfs2(node.right, sum, cur);
    }
}
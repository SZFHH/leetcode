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
    public int pathSum(TreeNode root, int sum) {
        return inner(root, sum, false) + inner(root, sum, true);
    }
    public int inner(TreeNode root, int sum, boolean isroot) {
        if(root==null){
            return 0;
        }
        if(isroot) {
            int v = inner(root.left, sum-root.val, true) + inner(root.right, sum-root.val, true);
            if(sum==root.val) v++;
            return v;
        } else {
            return inner(root.left, sum, true) + inner(root.left,sum,false)
                  +inner(root.right, sum, true) + inner(root.right, sum, false);
        }
    }
}
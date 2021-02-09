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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return inner(preorder, inorder,0,0,preorder.length);
    }

    public TreeNode inner(int[] pre, int[] in, int prest, int inst, int len) {
        if(len<=0) return null;
        int mid = pre[prest];
        int k = inst;
        while(in[k]!=mid) k++;
        TreeNode rv = new TreeNode(mid);
        rv.left = inner(pre, in, prest+1, inst, k-inst);
        rv.right = inner(pre, in, prest + k-inst +1,k+1, len - (k-inst+1));
        return rv;
    }
}
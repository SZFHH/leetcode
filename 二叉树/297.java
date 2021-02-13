/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int idx=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rserialize(root, sb);
        return sb.toString();
    }

    public void rserialize(TreeNode root, StringBuilder sb) {
        if(root==null) {
            if(sb.length()==0){
                sb.append("X");
            } else {
                sb.append(",X");
            }
            return;
            
        }
        if(sb.length()>0) {
            sb.append(',');
        }
        sb.append(root.val);
        rserialize(root.left, sb);
        rserialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        return rds(ss);
        
    }

    public TreeNode rds(String[] ss) {
        if(ss[idx].equals("X")) {
            idx++;
            return null;    
        }
        TreeNode node = new TreeNode(Integer.valueOf(ss[idx]));
        idx++;
        node.left = rds(ss);
        node.right = rds(ss);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
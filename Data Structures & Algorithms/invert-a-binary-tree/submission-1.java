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
        Queue<TreeNode> q1 = new LinkedList();
        q1.add(root);
        while(!q1.isEmpty()) {
            TreeNode node = q1.poll();
            if(null == node) continue;
            TreeNode nodeLeft = node.left;
            TreeNode nodeRight = node.right;
            TreeNode tmpNode = node.left;
            node.left = node.right;
            node.right = tmpNode;
            q1.add(node.left);
            q1.add(node.right);
        }
        return root;
    }
}

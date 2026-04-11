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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /**
            Do BFS and Match
        **/
        Queue<TreeNode> pQueue = new LinkedList();
        Queue<TreeNode> qQueue = new LinkedList();
        boolean isSameTree = true;
        pQueue.add(p);
        qQueue.add(q);
        while(!pQueue.isEmpty() || !qQueue.isEmpty()) {
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();
            if(null == pNode && null != qNode) {
                isSameTree = false;
                break;
            }
            if(null == qNode && null != pNode) {
                isSameTree = false;
                break;
            }
            if(pNode != null && qNode != null) {
                if( pNode.val != qNode.val) {
                    isSameTree = false;
                    break;
                }
                pQueue.add(pNode.left);
                pQueue.add(pNode.right);
                qQueue.add(qNode.left);
                qQueue.add(qNode.right);
            }
        }
        return isSameTree;
    }
}

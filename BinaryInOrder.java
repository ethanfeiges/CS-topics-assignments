import java.util.*;

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
// Time: O(N) (N nodes)
// Space: O(height of tree) (Maximum amount of things in callstack)
// Conducts in-order traversal of a binary tree displayed both iteratively and recursively.
// Solution to Leetcode problem #94
class BinaryInOrder {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        // Iterative:
        List<Integer> inOrder = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            // keep moving left:
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
                
            }
            // Adds root of the "null" left node. 
            cur = stack.pop();
            inOrder.add(cur.val);
            // Go to right
            cur = cur.right;
        }
        return inOrder;
        
        
        
        /* RECURSIVE:
        List<Integer> inOrder = new ArrayList<>();
        if(root == null){
            return inOrder;
        }
        helper(root, inOrder);
        return inOrder;
       */
    }
    public void helper(TreeNode root, List<Integer> inOrder){
        if(root == null){
            return;
        }
        // In-order traversal: Process left subtree, then center subtree, then right subtree
        helper(root.left, inOrder);
        inOrder.add(root.val);
        helper(root.right, inOrder);
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Resultant list to store the level order traversal
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }

        // Queue to facilitate level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // While there are nodes to process in the queue
        while (!queue.isEmpty()) {
            // List to store the current level's values
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size(); // Number of nodes in the current level

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Remove the node from the queue
                level.add(currentNode.val); // Add its value to the current level list

                // Add left child to queue if it exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // Add right child to queue if it exists
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Add the current level's list to the result list
            result.add(level);
        }

        return result;
    }
}

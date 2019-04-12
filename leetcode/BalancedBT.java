/*****************************************************************
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * Example 1:
 * 
 * Given the following tree [3,9,20,null,null,15,7]:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 * 
 * Example 2:
 * 
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * 
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 * 
 * @author liwenwei
 * 
 ***************************************************************/

public class BalancedBT {
	
	/**
	 * 1. Top-down 
	 * checks whether the tree is balanced strictly according to the definition of 
	 * balanced binary tree: the difference between the heights of the two sub trees 
	 * are not bigger than 1, and both the left sub tree and right sub tree are also balanced.
	 * 
	 * Each node in the tree only need to be accessed once, then get the depth of each node, 
	 * so Time complexity: O(n) = NlogN
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		int ldepth = depth(root.left);
		int rdepth = depth(root.right);
		return Math.abs(ldepth - rdepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int depth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
	
	/**
	 * 2. based on DFS. 
	 * Instead of calling depth() explicitly for each child node, we return the 
	 * height of the current node in DFS recursion. When the sub tree of the current
	 * node (inclusive) is balanced
	 * 
	 * Each node in the tree only need to be accessed once, so Time complexity: O(n) = N
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalancedII(TreeNode root) {
		return dfs(root) != -1;
	}
	
	// 深度优先遍历每个节点
	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int ldepth = dfs(root.left);
		if (ldepth == -1) return -1;
		int rdepth = dfs(root.right);
		if (rdepth == -1) return -1;
		if (Math.abs(ldepth - rdepth) > 1) return -1;
		return Math.max(ldepth, rdepth) + 1;
	}
}

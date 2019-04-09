/*****************************************************************
 * 701. Insert into a Binary Search Tree
 * 
 * For example, 
 * 
 * Given the tree:
 *        4
 *       / \
 *      2   7
 *     / \
 *    1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 * 
 *         4
 *       /   \
 *      2     7
 *     / \   /
 *    1   3 5
 * 
 * 
 * @author liwenwei
 * 
 ***************************************************************/

public class InsertBST {
	
	// recursive
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (root.val > val) {
			root.left = insertIntoBST(root.left, val);
		} else if (root.val < val) {
			root.right = insertIntoBST(root.right, val);
		}
		return root;
	}
	
	public TreeNode insertIntoBSTII(TreeNode root, int val) {
		if (root == null) return new TreeNode(val);
		TreeNode curr = root;
		while (true) {
			if (curr.val > val) {
				if (curr.left == null) {
					curr.left = new TreeNode(val);
					break;
				} else {
					curr = curr.left;
				}
			} else {
				if (curr.right == null) {
					curr.right = new TreeNode(val);
					break;
				} else {
					curr = curr.right;
				}
			}
		}
		return root;
	}
}

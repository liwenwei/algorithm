/*****************************************************************
 * 98. Validate Binary Search Tree
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * 分析：提到BST的特征是，BST任意节点的左子树始终小于父节点，右子树始终大于父节点，
 * 我们很容易想到
 * isValidBST(node.left)
 * if (node < left || node > right) return false
 * isValidBST(node.right)
 * 但其实这种做法是错误的，首先只判断的当前node的left和right，但是忽略了node的parent node
 * 
 * 
 * @author liwenwei
 * 
 ***************************************************************/

import java.util.Stack;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
    	return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null) return true;
		if (root.val <= minVal || root.val >= maxVal) return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}
    
    public boolean isValidBSTII(TreeNode root) {
    	if (root == null) return true;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode pre = null;
    	while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val <= pre.val) return false;
			pre = root;
			root = root.right;
		}
    	return true;
	}
}

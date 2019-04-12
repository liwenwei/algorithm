/*****************************************************************
 * 230. Kth Smallest Element in a BST
 * 
 * Given a binary search tree, write a function kthSmallest to find 
 * the kth smallest element in it.
 * 
 * Example 1:
 * 
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * 
 * @author liwenwei
 * 
 ***************************************************************/
import java.util.Stack;

public class KthBST {

    public int kthSmallest(TreeNode root, int k) {
    	if (root == null) return Integer.MIN_VALUE;
    	Stack<TreeNode> stack = new Stack<>();
    	int n = 0;
    	while (root != null || stack.empty()) {
    		while (root != null) {
    			stack.push(root);
    			root = root.left;
    		}
    		root = stack.pop();
    		if (++n == k) return root.val;
    		root = root.right;
    	}
    	return Integer.MIN_VALUE;
    }
	
}

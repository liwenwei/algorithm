/*****************************************************************
 * 99. Recover Binary Search Tree
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * 分析：
 * <p>1. 二叉搜索树使用的是中序遍历，因此使用中序遍历查找两个错误的节点</p>
 * <p>2. 二叉搜索树[2 1 4 null null 3 5]中序遍历后为 [1 2 3 4 5], 随便打乱其中两个node
 * [1 3 2 4 5]
 *    - -
 * [4 2 3 1 5]
 *  -     -
 * [1 4 3 2 5]
 *    -   -
 * [5 2 3 4 1]
 *  -       -
 * 根据规律可发现，<b>第一打乱的元素始终小于>下一个元素，第二个打乱元素<上个元素</b>。
 * </p>
 * 
 * @author liwenwei
 * 
 ***************************************************************/

public class RecoverBST {
	
	private TreeNode firstNode = null;
	private TreeNode secondNode = null;
	private TreeNode preNode = null;
	
	public void recoverTree(TreeNode root) {
		traversal(root);
		// swap the nodes
		int temp = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = temp;
	}
	
	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public void traversal(TreeNode root) {
		if (root == null) return;
		traversal(root.left);
		// Begin do something
		if (preNode != null) {
			// 第一个打乱元素始终大于下个元素，取preNode为firstNode
			if (firstNode == null && preNode.val > root.val) {
				firstNode = preNode;
			}
			// 第二个打乱元素始终小于上个元素，取root为secondNode
			if (firstNode != null && preNode.val > root.val) {
				secondNode = root;
			}
		}
		preNode = root;
		// end do something
		traversal(root.right);
	}
	
}

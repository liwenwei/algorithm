/*****************************************************************
 * 173. Binary Search Tree Iterator
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator 
 * will be initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * @author liwenwei
 * 
 ***************************************************************/

import java.util.ArrayList;
import java.util.List;

class BSTIterator {
	TreeNode root;
	List<TreeNode> nodes = new ArrayList<TreeNode>();
	int N;

    public BSTIterator(TreeNode root) {
        this.root = root;
        N = 0;
        convertToSortedList(root);
    }
    
    private void convertToSortedList(TreeNode node) {
    	if (node == null) return;
    	convertToSortedList(node.left);
    	nodes.add(node);
    	convertToSortedList(node.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) {
        	return Integer.MIN_VALUE;
        }
        return nodes.get(N++).val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return N < nodes.size();
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		TreeNode right = new TreeNode(15);
		right.left = new TreeNode(9);
		right.right = new TreeNode(20);
		root.right = right;
		
		BSTIterator iterator = new BSTIterator(root);
		for (TreeNode node : iterator.nodes) {
			System.out.println(node.val);
		}
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
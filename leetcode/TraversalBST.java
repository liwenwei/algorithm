/*****************************************************************
 * 94. Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author liwenwei
 * 
 ***************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalBST {

    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.empty()) {
        	while (root != null) {
        		stack.push(root);
        		root = root.left;
        	}
        	root = stack.pop();
        	list.add(root.val);
        	root = root.right;
        }
        return list;
    }
    
    public List<Integer> inorderTraversalII(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        inorderTraversalII(root, list);
        return list;
    }
    
    private void inorderTraversalII(TreeNode root, List<Integer> list) {
    	if (root == null) return;
    	inorderTraversalII(root.left);
    	if (root != null) list.add(root.val);
    	inorderTraversalII(root.right);
    	
    }
    
}

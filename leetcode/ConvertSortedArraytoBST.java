/*****************************************************************
 * 108. Convert Sorted Array to Binary Search Tree
 * 
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * 分析： 
 * 1. 先找到根节点，然后递归找到左右子节点
 * 2. 如果找根节点？因为是平衡二叉树，所以根节点的左右子树的节点一定趋近于相等，所以nums[start, end],
 * 取[start, end]的中间节点mid即为root节点
 * 3. 然后依次类推
 * 
 * @author liwenwei
 * 
 ***************************************************************/


public class ConvertSortedArraytoBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
    	if (start <= end) {
    		int mid = start + (end - start) / 2;
        	TreeNode node = new TreeNode(nums[mid]);
        	node.left = sortedArrayToBST(nums, start, mid - 1);
        	node.right = sortedArrayToBST(nums, mid + 1, end);
        	return node;
    	}
    	return null;
	}
	
}

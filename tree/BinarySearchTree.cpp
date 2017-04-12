#include "BinarySearchTree.h"

bool BinarySearchTree::isValidBST(TreeNode* root, long minVal, long maxVal) {
    if (root == NULL) return true;
    if (root->val >= maxVal || root->val <= minVal) return false;
    return isValidBST(root->left, minVal, root->val) && isValidBST(root->right, root->val, maxVal);
}

bool BinarySearchTree::isValidBST(TreeNode* root){
    return isValidBST(root, LONG_MIN, LONG_MAX);
}

TreeNode* BinarySearchTree::search(TreeNode* root, int val)
{
    if (!root) return NULL;
    TreeNode* node = root;
    while (node)
    {
        if (val < node->val)
            node = node->left;
        else if (val>node->val)
            node = node->right;
        else
            return node;
    }
    return NULL;
}

bool BinarySearchTree::insert_recursion(TreeNode* root, int val)
{
    if (!root){
        root = new TreeNode(val);
        return true;
    }
    if (val < root->val){
        insert_recursion(root->left, val);
    }
    else if (val > root->val){
        insert_recursion(root->right, val);
    }
    return false;
}

bool BinarySearchTree::insert_iterative(TreeNode* root, int val)
{
    if (!root)
    {
        root = new TreeNode(val);
        return true;
    }

    TreeNode* node = root;
    while (node)
    {
        if (val < node->val){
            node = node->left;
        }
        else if (val > node->val){
            node = node->right;
        }
        else{
            return false;
        }
    }

    if (val < node->val) {
        node->left = new TreeNode(val);
    }
    else if (val > node->val) {
        node->right = new TreeNode(val);
    }
    return true;
}
#include <iostream>
#include <algorithm>

using namespace std;

struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

bool isValidBST(TreeNode* root, long minVal, long maxVal) {
    if (root == NULL) return true;
    if (root->val >= maxVal || root->val <= minVal) return false;
    return isValidBST(root->left, minVal, root->val) && isValidBST(root->right, root->val, maxVal);
}

bool isValidBST(TreeNode* root){
    return isValidBST(root, LONG_MIN, LONG_MAX);
}
#include <iostream>
#include <algorithm>

using namespace std;

struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

int maxDepth1(TreeNode* root)
{
    if (root == NULL) return 0;
    int depth, left, right;
    left = maxDepth1(root->left);
    right = maxDepth1(root->right);
    depth = left > right ? left : right + 1;
    return depth;
}

/*
* Depth-First-Search
**/
int maxDepth(TreeNode* root)
{
    if (root == NULL) return 0;

    return max(maxDepth(root->left), maxDepth(root->right)) + 1;
}

/*
*
* Two binary tress are considered equal if they are structurally identical and the nodes have the same value
*
**/
bool isSameTree(TreeNode* p, TreeNode* q)
{
    if (p == NULL && q == NULL) return true;
    if (p == NULL || q == NULL) return false;

    return p->val == q->val && isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
}
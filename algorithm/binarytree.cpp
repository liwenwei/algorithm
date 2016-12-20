#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) :
        val(x), left(nullptr), right(nullptr){}
};

/*
*
* Determine if the tree has root-to-leaf path such that adding up all the values along the path equals the given sum
**/
bool hasPathSum(TreeNode* root, int sum)
{
    if (root == NULL) return false;

    if (root->left == NULL && root->right == NULL && root->val == sum) return true;

    return hasPathSum(root->left, sum - root->val) || hasPathSum(root->right, sum - root->val);
}

void searchTree(vector<string>& paths, string path, TreeNode* node)
{
    if (node->left == NULL && node->right == NULL) paths.push_back(path + to_string(node->val));
    if (node->left != NULL) searchTree(paths, path + "->" + to_string(node->val), node->left);
    if (node->right != NULL) searchTree(paths, path + "->" + to_string(node->val), node->right);
}

vector<string> binaryTreePaths(TreeNode* root)
{
    vector<string> paths;
    if (root == NULL) return paths;

    searchTree(paths, to_string(root->val), root);
    return paths;
}

int main()
{
}
/*
* Binary Search Tree(BST)
*/
#pragma once
#include <iostream>
#include <algorithm>

using namespace std;

struct TreeNode{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class BinarySearchTree
{
public:
    BinarySearchTree(){}
    ~BinarySearchTree(){}

    bool isValidBST(TreeNode* root, long minVal, long maxVal);
    bool isValidBST(TreeNode* root);

    TreeNode* search(TreeNode* root, int val);

    bool insert_recursion(TreeNode* root, int val);
    bool insert_iterative(TreeNode* root, int val);

private:

};
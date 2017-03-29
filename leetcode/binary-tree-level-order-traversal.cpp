#include <vector>
#include <queue>
#include <iostream>

using namespace std;
//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:

    /*
    * Void BFS(int i, int j)
    * {
    *     初始化队列Q；
    *        while (Q不为空）
    *        {
    *            取出队首元素u;
    *            枚举元素u的相邻区域， if (此区域有油)
    *            {
    *                入队; 访问标记;
    *            }
    *        }
    * }
    */

    vector<vector<int>> levelOrder(TreeNode* root)
    {
        vector<vector<int>> result;
        queue<TreeNode *> que;

        if (root != nullptr)
        {
            que.emplace(root); // TODO: what's the difference between emplace() and push(), emplace_back() and push_back()
        }

        while (!que.empty())
        {
            vector<int> level;
            int size = que.size();
            for (int i = 0; i < size; i++)
            {
                auto *front = que.front();
                que.pop();
                level.emplace_back(front->val);
                if (front->left != nullptr)
                {
                    que.emplace(front->left);
                }
                if (front->right != nullptr)
                {
                    que.emplace(front->right);
                }
            }
            result.emplace_back(move(level));
        }

        return result;
    }
};

int main()
{
    TreeNode root(3);
    TreeNode node1(9);
    TreeNode node2(20);
    TreeNode node3(15);
    TreeNode node4(7);

    root.left = &node1;
    root.right = &node2;
    node2.left = &node3;
    node2.right = &node4;

    Solution solution;
    vector<vector<int>> result = solution.levelOrder(&root);
    for (vector<vector<int>>::iterator i = result.begin(); i != result.end(); ++i)
    {
        vector<int> level = *i;
        for (vector<int>::iterator j = level.begin(); j != level.end(); ++j)
        {
            cout << *j << " ";
        }
        cout << endl;
    }
}
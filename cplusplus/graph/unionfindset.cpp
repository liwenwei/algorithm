#include "unionfindset.h"


unionfindset::unionfindset(int n)
{
    m_N = n;
    m_Parent = new int[m_N];
    for (size_t i = 0; i < m_N; i++)
    {
        m_Parent[i] = i;
    }
}

unionfindset::~unionfindset()
{
    if (m_Parent != NULL)
    {
        delete[] m_Parent;
        m_Parent = NULL;
    }
}

int unionfindset::Find(int val)
{
    if (val < 0 || val >= m_n){
        return -1;
    }

    int root = val;
    while (root != m_parent[root])
    {
        root = m_parent[root];
    }

    int temp = val;
    int parent;
    while (temp != root)
    {
        parent = m_parent[temp];  // t2的原父节点
        m_parent[temp] = root;    // t2的父节点直接复制给根temp
        temp = parent;            // 沿着原来的父节点继续向上查找
    }

    return root;
}

void unionfindset::Union(int i, int j)
{
    if (i < 0 || i >= m_n || j < 0 || j >= m_n)
    {
        return;
    }

    int ri = Find(i);
    int rj = Find(j);
    if (ri != rj)
    {
        m_parent[ri] = rj;
    }
}
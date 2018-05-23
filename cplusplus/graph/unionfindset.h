#pragma once
#include <iostream>
/*
* union-find algorithm
*/

class unionfindset
{
public:
    unionfindset(int n);
    ~unionfindset();

    void Union(int i, int j);
    int Find(int i);
    void Print() const;

private:
    int m_n;
    int* m_parent;
};


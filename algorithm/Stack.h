#pragma once

#include <queue>

using namespace std;

class MyClass
{
public:

    // Push element x onto stack
    void push(int x)
    {
        m_queue.push(x);

        for (size_t i = 0; i < m_queue.size() - 1; i++)
        {
            m_queue.push(m_queue.front);
            m_queue.pop();
        }
    }

    // Removes the element on top of the stack
    void pop()
    {
        m_queue.pop();
    }

    // Get the top element
    int top()
    {
        return m_queue.front();
    }

    // Return whether the stack is empty
    bool empty()
    {
        m_queue.empty();
    }

private:
    queue<int> m_queue;
};

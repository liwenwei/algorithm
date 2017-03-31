#pragma once

#include <queue>
#include <stack>
#include <string>

using namespace std;

/*
* Implment the stack by queue
*/
class Stack
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
        return m_queue.empty();
    }

private:
    queue<int> m_queue;
};

/*
*
* Valid Parentheses
**/
bool isValidParentheses(string s)
{
    stack<char> parenthese;
    for (size_t i = 0; i < s.length(); i++)
    {
        switch (s[i])
        {
        case '(':
        case '[':
        case '{':
            parenthese.push(s[i]);
            break;
        case ')':
            if (parenthese.size() != 0 && parenthese.top() == '(') parenthese.pop(); else return false; break;
        case ']':
            if (parenthese.size() != 0 && parenthese.top() == '[') parenthese.pop(); else return false; break;
        case '}':
            if (parenthese.size() != 0 && parenthese.top() == '{') parenthese.pop(); else return false; break;
        default:; // pass
        }
    }

    return parenthese.empty();
}

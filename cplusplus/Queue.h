#pragma once
#include <stack>

using namespace std;

class Queue
{
public:
    // Push element x to the back of the queue
    void push(int x)
    {
        input.push(x);
    }

    // Removes the element from in front of queue
    void pop(void)
    {
        peek();
        output.pop();
    }

    // Get the front element
    int peek()
    {
        if (output.empty())
        {
            while (!input.empty())
            {
                output.push(input.top());
                input.pop();
            }
        }

        return output.top();
    }

    // Return whether the queue is empty
    bool empty(void)
    {
        return input.empty() && output.empty();
    }

private:
    stack<int> input, output;
};
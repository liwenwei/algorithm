
/*
* Reverse Polish Notation
*/

#include <stack>
using namespace std;

bool IsOperator(const char* token)
{
    return ((token[0] == '+') || (token[0] == '-')
        || (token[0] == '*') || (token[0] == '/'));
}

int ReversePolishNotation(const char* str[], int size)
{
    stack<int> s;
    int a, b;
    const char* token;
    for (int i = 0; i < size; i++)
    {
        token = str[i];
        if (!IsOperator(token))
        {
            s.push(atoi(token));
        }
        else
        {
            b = s.top();
            s.pop();
            a = s.top();
            s.pop();
            if (token[0] == '+')
                s.push(a + b);
            else if (token[0] == '-')
                s.push(a - b);
            else if (token[0] == '*')
                s.push(a*b);
            else// if(token[0] == '/')
                s.push(a / b);
        }
    }
    return s.top();
}

int main()
{
    const char* str[] = { "2", "1", "+", "3", "*" };
    int value = ReversePolishNotation(str, sizeof(str) / sizeof(const char*));
    printf("RPN: %d", value);

    return 0;
}
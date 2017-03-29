

// A palindrome number is a number that remains the same when its digits are reversed, like 16461,484
// Compare half of the digits, so no need to deal with overflow
// like 1234321, get left = 123, right = 321 = reverse = 123 
bool isPalindrome(int x)
{
    if (x < 0 || (x != 0 && x % 10 == 0)) return false;
    int sum = 0;
    while (x > sum)
    {
        sum = sum * 10 + x % 10;
        x = x / 10;
    }
    return (x == sum) || (x == sum / 10);
}
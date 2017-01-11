/**********************************************
* Edit Distance algorithm
*
* Application Scenirio:
* - DNA 分析
* - Spell Check
*
* - ASR(Automatic Speech Recognition)
*   其目标是将人类的语音中的词汇内容转换为计算机可读的输入，例如按键、二进制编码或者字符序列。然后以此作为系统输入，和你的语料库进行对比。就可以利用最小编辑距离来匹配识别。
*
* - 抄袭侦测：串匹配算法是程序代码抄袭检测中标记匹配的重要算法，传统的模式匹配无法准确解决这个问题。
*   将原文本转化成能够描述程序特征的标记，这个标记可以是字符串、向量、xml文档等。
*   然后用串匹配算法实现对标记序列的匹配查找，计算出相似度的值。大多数的抄袭检测系统都会给出这个值， 一般来说，
*   相似度越大说明抄袭的可能性越大。
*
********************************************/
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

unsigned int levenshteinDistance(const std::string& s1, const std::string& s2)
{
    const size_t len1 = s1.size();
    const size_t len2 = s2.size();

    std::vector<std::vector<unsigned int>> d(len1 + 1, std::vector<unsigned int>(len2 + 1));

    d[0][0] = 0;
    for (size_t i = 1; i <= len1; i++)
    {
        d[i][0] = i;
    }

    for (size_t j = 1; j <= len2; j++)
    {
        d[0][j] = j;
    }

    for (size_t i = 1; i <= len1; i++)
    {
        for (size_t j = 1; j <= len2; j++)
        {
            // note that std::min({arg1, arg2, arg3}) works only in C++11,
            // for C++98 use std::min(std::min(arg1, arg2), arg3)
            d[i][j] = std::min({ d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + (s1[i - 1] == s2[j - 1] ? 0 : 1) });
        }
    }
    return d[len1][len2];
}

int main()
{
    int distance = levenshteinDistance("stecai1", "stecai");
    int distance1 = levenshteinDistance("kitten", "sitting");
    int distance2 = levenshteinDistance("Saturday", "Sunday");
    std::cout << distance << std::endl;
    std::cout << distance1 << std::endl;
    std::cout << distance2 << std::endl;
}
/*
 * @lc app=leetcode.cn id=20 lang=cpp
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
public:
    bool isValid(string s) {
        if(s.length() % 2 != 0) return false;
        unordered_map<char,char> map = {
            {'}','{'},
            {']','['},
            {')','('}
        };
        stack<char> stack;
        for(char c:s){
            if(map.count(c)>0){
                if(stack.empty() || map[c]!=stack.top()){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        
        }
        return stack.empty();
    }
};
// @lc code=end


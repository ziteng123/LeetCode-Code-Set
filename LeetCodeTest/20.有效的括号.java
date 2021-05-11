/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        Deque<Character> deque = new LinkedList<>();
        deque.isEmpty();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end


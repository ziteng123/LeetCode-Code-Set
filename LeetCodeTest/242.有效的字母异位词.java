import java.util.HashMap;
import java.util.Map;


/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> m1 = new HashMap<Character,Integer>();
        Map<Character,Integer> m2 = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            m1.merge(s.charAt(i),1,Integer::sum);
        }
        for(int i = 0; i < t.length(); i++){
            m2.merge(t.charAt(i),1,Integer::sum);
        }
        for(int i = 0; i < s.length(); i++){
            if(m2.get(s.charAt(i))==null || (m1.get(s.charAt(i))!=m2.get(s.charAt(i))))
                return false;
        }
        return true;

    }
}
// @lc code=end


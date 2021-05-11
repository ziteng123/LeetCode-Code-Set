/*
 * @lc app=leetcode.cn id=215 lang=cpp
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, less<int>> q;
        for(int n:nums){
            if(q.size()<k){
                q.push(n);
            }else if(q.top()<n){
                q.pop();
                q.push(n);
            }
        }
        for(int i = k; i > 1; i--){
            q.pop();
        }
        if(!q.empty()){
            int num = q.top();
            q.pop();
        }
        
        return num;
    }
};
// @lc code=end


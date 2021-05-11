/*
 * @lc app=leetcode.cn id=239 lang=cpp
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        if(k == 1 || nums.size()==0) return nums;
        int n = nums.size();
        // 创建一个双端队列,只允许队尾插入，队头保留最大元素
        // 维护一个从队头到队尾单调递减的双端队列，队列保存元素的下标，并且也是单调递减的
        deque<int> q;
        for(int i = 0; i < k; i++){
            // 如果队列为非空并且新元素大于队尾元素，就抛出队尾元素
            while(!q.empty() && nums[i]>=nums[q.back()]){
                q.pop_back();
            
            }
            q.push_back(i);
        }
        vector<int> res = {nums[q.front()]};
        for(int i = k; i < n; i++){
            // 处理新元素
            while(!q.empty() && nums[i]>=nums[q.back()]){
                q.pop_back();
            }
            q.push_back(i);
            // 如果队头元素不在当前窗口，则抛出
            // 找出当前窗口的最大值
            while(q.front() <= i-k){
                q.pop_front();
            }
            res.emplace_back(nums[q.front()]);
        }
        return res;

    }
};
// @lc code=end


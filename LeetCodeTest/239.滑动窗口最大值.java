import java.util.Deque;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1 || nums.length == 0) return nums;
        int n = nums.length;
        Deque<Integer> q = new LinkedList<Integer>();
        int[] arr = new int[n-k+1];
        for(int i = 0; i < n; i++){
            // 保证单调队列是单调递减的
            while(!q.isEmpty() && nums[i]>=nums[q.peekLast()]){
                q.pollLast();
            }
            q.offerLast(i);
            
            // 只有当判断到第k-1个元素时，才会取出第一个窗口的最大值
            if(i+1>=k){
                // 找出当前窗口的最大值，首先判断是否是第一个窗口，如果是第一个窗口，则直接返回队首元素下标对应的值
                // 否则，判断队头元素是否在该窗口，不在，则抛出
                while(q.peekFirst()<=i-k){
                    q.pollFirst();
                }
                arr[i-k+1] = nums[q.peekFirst()];
            }
            

        }
        
        return arr;
    }
}
// @lc code=end


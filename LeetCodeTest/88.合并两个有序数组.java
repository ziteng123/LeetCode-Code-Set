/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m-1;
        int k = n-1;
        int s = m+n-1;
        while(l >= 0 && k >= 0){
            if(nums1[l]>=nums2[k]){
                nums1[s] = nums1[l];
                l--;
            } else {
                nums1[s] = nums2[k];
                k--;
            }
            s--;
        }
        if(k >= 0){
            for(int i = k; i >= 0; i--){
                nums1[s--] = nums2[i];
            }
        }
    }
}
// @lc code=end


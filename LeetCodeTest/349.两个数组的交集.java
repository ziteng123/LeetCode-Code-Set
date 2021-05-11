import java.util.Map;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       int len1 = nums1.length;
       int len2 = nums2.length;
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       List<Integer> list = new ArrayList<Integer>();
       int i = nums1[0];
       int j = nums2[0];
       while(i < len1 && j < len2){
           if(nums1[i] == nums2[j]){
               list.add(nums1[i]);
           }else if(nums1[i]<nums2[j]){
                i++;
           }else{
               j++;
           }
       }
       // 转换数组
       int[] arr = new int[list.size()];
       for(int k = 0; k < list.size(); k++){
           arr[k] = list.get(k);
       }
       return arr;
    }
}
// @lc code=end


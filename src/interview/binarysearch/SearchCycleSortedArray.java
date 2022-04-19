package interview.binarysearch;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/20 22:21
 */
public class SearchCycleSortedArray {


    /**
     * 有一个长度为 n 的按严格升序排列的整数数组 nums ，在实行 search 函数之前，在某个下标 k 上进行旋转，使数组变为[nums[k],nums[k+1],.....,nums[nums.length-1],nums[0],nums[1],.......,nums[k-1]]。
     * 给定旋转后的数组 nums 和一个整型 target ，请你查找 target 是否存在于 nums 数组中并返回其下标（从0开始计数），如果不存在请返回-1。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //> (left,mid)区间有序
            if (nums[mid] >= nums[left]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //>(mid,right)区间有序
            else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}

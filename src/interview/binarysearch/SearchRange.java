package interview.binarysearch;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/5/3 22:42
 */
public class SearchRange {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;
        if (left >= 0 && left < nums.length && nums[left] == target) {
            res[0] = left;
        }
        if (right >= 0 && right < nums.length && nums[right] == target) {
            res[1] = right;
        }


        return res;

    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        //>如果lower为true，则寻找第一个大于等于target的数，否则寻找第一个大于target的数
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 7, 79};

        System.out.println(new SearchRange().binarySearch(data, 6, true));
    }
}

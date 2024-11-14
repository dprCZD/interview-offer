package interview.binarysearch;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/14 22:14
 */
public class MedianinTwoSortedAray {


    /**
     * 给定两个递增数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
     * 上中位数：假设递增序列长度为n，为第n/2个数
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        // write code here
        if (arr1.length == 0 || arr2.length == 0) {
            return 0;
        }
        int left1 = 0;
        int left2 = 0;
        int right1 = arr1.length - 1;
        int right2 = arr2.length - 1;
        while (left1 < right1) {
            int mid1 = (left1 + right1) / 2;
            int mid2 = (left2 + right2) / 2;
            int offset = (right1 - left1 + 1) % 2 == 0 ? 1 : 0;//偏移量，判断是否奇偶
            if (arr1[mid1] > arr2[mid2]) {
                //> 代表中位数在arr1[left1:mid1]和arr2[mid2+offset:right2]之间
                left2 = mid2 + offset;
                right1 = mid1;
            } else if (arr1[mid1] < arr2[mid2]) {
                //> 代表中位数在arr1[mid1+offset:right1]和arr2[left2:mid2]之间
                right2 = mid2;
                left1 = mid1 + offset;
            } else {
                return arr1[mid1];
            }
        }
        return Math.min(arr1[left1], arr2[left2]);
    }

    /**
     * @param arr1
     * @param arr2
     * @return
     */

    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        //> 我们使用一个小trick，我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (findKth(arr1, 0, arr2, 0, left) + findKth(arr1, 0, arr2, 0, right)) / 2.0;
    }

    //i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if (j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        //> 递归出口
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        //>二分比较，缩小数组范围。k-k/2是减小搜索范围，逐步求精
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}

package interview.binarysearch;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/3/7 22:27
 */
public class ReverseSortedArraySearch {

    public static int search(int[] A, int target) {
        // write code here
        int left = 0;
        int right = A.length - 1;

        //中间的断点
        int p = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid + 1 >= A.length || mid - 1 < 0) {
                p = A.length - 1;
                break;
            }
            if ((A[mid - 1] > A[mid] && A[mid + 1] > A[mid])) {
                p = mid;
                break;
            } else if (A[mid] > A[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (target >= A[0]) {
            left = 0;
            right = p;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == A[mid]) {
                    return mid;
                } else if (target > A[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        } else {
            left = p;
            right = A.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == A[mid]) {
                    return mid;
                } else if (target > A[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public  int search1(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return mid;
            }
            //这里说明从left-mid段是有序的。
            if (A[left] <= A[mid]) {
                //这里说明target在left-mid段内。
                if (A[left] <= target && A[mid] > target) {
                    right = mid - 1;
                }
                //否则不在left-mid段内
                else {
                    left = mid + 1;
                }
            }
            //说明从mid-right段是有序的。
            else {
                //这里说明target在mid-right段内
                if (A[right] >= target && A[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;

                }
            }
        }
        return -1;
    }

        public static void main(String[] args) {
        int array[] = {1, 3};
        search(array, 3);
    }

}

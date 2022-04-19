package interview.binarysearch;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/10/6 21:43
 */
public class BinarySearch {


    int basicSearch(int target, int array[]) {
        int left = 0;
        int right = array.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    static int left(int target, int[] array) {
        int left = 0;
        int right = array.length;
        int mid = -1;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int right(int target, int[] array) {
        int left = 0;
        int right = array.length;
        int mid = -1;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right-1;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 7, 7, 7, 79};
        System.out.println(right(6, data));
        System.out.println(left(6, data));

    }
}

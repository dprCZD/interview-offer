package interview.binarysearch;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/3/22 22:50
 */
public class MinNumberInRotateArray {

    /**
     * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，
     * 变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0){
            return -1;
        }
        int left =0;
        int right =array.length-1;

        while(left<right){
            int mid =(left+right)/2;
            if(array[mid]>array[array.length-1]){
                left=mid+1;
            } else if(array[mid]<=array[mid+1]){
                right=mid;
            } else {
                return array[mid+1];
            }
        }
        return right;

    }
}

package interview.math;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/11 21:28
 */
public class Sqrt {

    /**
     * 二分法计算
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <=1) {
            return x;
        }
        int left =1;int right =x;
        while(left<=right){
            int mid =(right+left)/2;
            if(mid<=x/mid&&(mid+1)>x/(mid+1)){
                return mid;
            } else if(mid>x/mid){
                right=mid-1;
            } else{
                left=mid+1;
             }
        }
        return x;
    }

}

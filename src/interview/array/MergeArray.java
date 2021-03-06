package interview.array;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/1/17 16:22
 */
public class MergeArray {

    /**
     * 归并 排序合并 的小步骤。
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int A[], int m, int B[], int n) {
        int []temp=new int[m+n];
        int i=0;int j=0;
        int k=0;
        while(i<m&&j<n){
            temp[k++]=A[i]>B[j]?B[j++]:A[i++];
        }
        while(i<m){
            temp[k++]=A[i++];
        }
        while(j<n){
            temp[k++]=B[j++];
        }
        System.arraycopy(temp, 0, A, 0, temp.length);

    }

    public int JumpFloor(int target) {
        if(target<=0)
            return 0;
        if(target==1)
            return 1;
        if(target==2)
            return 2;
        int res[]=new int[3];
        res[0]=1;
        res[1]=2;
        for(int i=2;i<target;i++){
            res[2]=res[0]+res[1];
            res[0]=res[1];
            res[1]=res[2];
        }
        return res[2];
    }

    public static void main(String[] args) {


    }
}

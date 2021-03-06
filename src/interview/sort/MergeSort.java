package interview.sort;

/**
 * @Author: czd
 * @Description:
 * @Date: 2020/12/27 21:30
 */
public class MergeSort {

    public static void main(String[] args) {
        int []array={5,7,6,3,2,4,898};
        mergeSort(array);
        for(int data:array){
            System.out.println(data);
        }
    }


    public static void mergeSort(int[] array){

        subMergeSort(array,new int[array.length],0,array.length-1);

    }

    public static void subMergeSort(int []array,int []temp,int start,int end){
        //递归出口
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        int s1=start;
        int e1=mid;
        int s2=mid+1;
        int e2=end;
        int k=start;
        //递归分割数组
        subMergeSort(array,temp,s1,e1);
        subMergeSort(array,temp,s2,e2);
        //合并数组
        while(s1<=e1&&s2<=e2){
            temp[k++]=array[s1]<=array[s2]?array[s1++]:array[s2++];
        }
        //尾巴处理
        while(s1<=e1){
            temp[k++]=array[s1++];
        }
        while(s2<=e2){
            temp[k++]=array[s2++];
        }
        //写回数组
        for(int i=start;i<=end;i++){
            array[i]=temp[i];
        }
    }
}

package interview.sort;

import java.util.ArrayList;

/**
 * @Author: czd
 * @Description:
 * 堆排序的时间复杂度为O(nlogn)，需要一个临时空间用于交换元素，所以空间复杂度为O(1)，堆排序的位置交换也是跳跃式的，是一个不稳定的排序方法。
 * @Date: 2020/12/20 17:53
 */
public class HeapSort {


    public static void main(String[] args) {
        int array[]={4,5,1,6,2,7,3,8};

        for(int i:array){
            System.out.println(i);
        }
        System.out.println(GetLeastNumbers(array,4).toString());
    }

    public static void heapSort(int []array){
        int len=array.length;
        //初始建堆，从第一个有子节点的节点开始调整
        for(int i= len/2-1;i>=0;i--){
            adjustHeapMax(array,i,len);
        }
        for(int i=1;i<array.length;i++){
            //交换元素
            int temp= array[0];
            array[0]=array[len-1];
            array[len-1]=temp;
            //设置边界
            len--;
            //调整堆
            adjustHeapMax(array,0,len);

        }

    }

    /**
     * 调整大根堆
     * @param array
     * @param curIndex
     * @param max
     */
    private static void adjustHeapMax(int []array, int curIndex, int max){
       int temp=array[curIndex];
       int child=curIndex*2+1;
       while(child<max){
           //左右孩子选取较大的那个
           if(child+1<max&&array[child+1]>array[child]){
               child++;
           }
           //当前节点大于子节点，终止调整
           if(temp>array[child]){
               break;
           }

           //父子节点进行交换
           array[curIndex]=array[child];
           array[child]=temp;

           //继续向下层调整
           curIndex=child;
           child=2*curIndex+1;
       }
    }

    /**
     * 调整小根堆
     * @param array
     * @param curIndex
     * @param max
     */
    private static void adjustHeapMin(int []array, int curIndex, int max){
        int temp=array[curIndex];
        int child=curIndex*2+1;
        while(child<max){
            //左右孩子选取较小的那个
            if(child+1<max&&array[child+1]<array[child]){
                child++;
            }
            //当前节点小于子节点，终止调整
            if(temp<array[child]){
                break;
            }

            //父子节点进行交换
            array[curIndex]=array[child];
            array[child]=temp;

            //继续向下层调整
            curIndex=child;
            child=2*curIndex+1;
        }
    }

    /**
     * 获取最小的k个数，基于小根堆实现。
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers(int [] input, int k) {

        int len= input.length;
        if(len==0||len<k){
            return new ArrayList<>();
        }
        for(int i=len/2-1;i>=0;i--){
            adjustHeapMin(input,i,len);
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++){
            int temp=input[0];
            input[0]=input[len-1];
            input[len-1]=temp;
            res.add(temp);
            len--;
            adjustHeapMin(input,0,len);
        }
        return res;

    }
}

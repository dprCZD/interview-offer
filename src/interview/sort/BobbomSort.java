package interview.sort;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/6/3 11:34
 */
public class BobbomSort   {

    public static void sort (int[] array){
        if(array==null||array.length==0){
            return;
        }
        for(int i =0;i<array.length-1;i++){
            for(int j = 1;j<array.length-i;j++){
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                }
            }
        }
    }

    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i]=array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {6,5,4,3,2,1};
        sort(array);
        for(int num :array){
            System.out.println(num);
        }

    }
}

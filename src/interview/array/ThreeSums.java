package interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/3/27 17:50
 */
public class ThreeSums {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length<3){
            return new ArrayList<>();
        }
        //i为第一位数的指针
        for(int pointer1=0;pointer1<nums.length;pointer1++){
            //如果两个数相等则跳过，避免重复解
            if(pointer1>0&&nums[pointer1]==nums[pointer1-1]){
                continue;
            }
            //如果第一位数>0说明之后的三数不可能等于0，跳过。
            if(nums[pointer1]>0){
                break;
            }
            //确定第一位数后，在第一位数的范围内进行遍历。
            int pointerL =pointer1+1;
            int pointerR=nums.length-1;
            while(pointerL<pointerR){
                //相等则添加结果
                if(nums[pointer1]+nums[pointerL]+nums[pointerR] ==0){
                    List<Integer> subRes=new ArrayList<>();
                    subRes.add(pointer1);
                    subRes.add(pointerL);
                    subRes.add(pointerR);
                    res.add(subRes);
                    //左侧指针去重
                    while (pointerL<pointerR&&nums[pointerL]==nums[pointerL+1]){
                        pointerL++;
                    }
                    //右侧指针去重
                    while (pointerL<pointerR&&nums[pointerR]==nums[pointerR-1]){
                        pointerR--;
                    }
                    //左右指针前进
                    pointerL++;
                    pointerR--;
                } else if(nums[pointer1]+nums[pointerL]+nums[pointerR] >0){
                    pointerR--;
                } else {
                    pointerL++;
                }

            }

        }

        return res;
    }
}

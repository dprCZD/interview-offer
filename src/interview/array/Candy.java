package interview.array;

import java.util.*;
public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null|| ratings.length == 0)
        {
            return 0;
        }
        int n = ratings.length;
        if(n == 1)
        {
            return 1;
        }
        int []left = new int[n];

        int candyCount = 1;
        left[0] = 1;
        for(int i =1;i<n;i++)
        {
            if(ratings[i-1]<ratings[i])
            {
                candyCount++;
            }else{
                candyCount = 1;
            }
            left[i] = candyCount;
        }

        int right = 1;
        int sum = left[n-1];
        for(int i = n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                right++;
            }
            else{
                right = 1;
            }
            sum += Math.max(right,left[i]);
        }
        return sum;

    }

    //我们从左到右枚举每一个同学，记前一个同学分得的糖果数量为 pre：
    //
    //如果当前同学比上一个同学评分高，说明我们就在最近的递增序列中，直接分配给该同学 pre+1 个糖果即可。
    //
    //否则我们就在一个递减序列中，我们直接分配给当前同学一个糖果，并把该同学所在的递减序列中所有的同学都再多分配一个糖果，以保证糖果数量还是满足条件。
    //
    //我们无需显式地额外分配糖果，只需要记录当前的递减序列长度，即可知道需要额外分配的糖果数量。
    //
    //同时注意当当前的递减序列长度和上一个递增序列等长时，需要把最近的递增序列的最后一个同学也并进递减序列中。
    public int candy2(int[] ratings) {
        if(ratings == null|| ratings.length == 0)
        {
            return 0;
        }
        int n = ratings.length;
        if(n == 1)
        {
            return 1;
        }
        int increase = 1;
        int decrease = 0;
        int pre =1;
        int sum = 1;
        for(int i =1;i<n;i++)
        {
            if(ratings[i]>=ratings[i-1])
            {
                decrease = 0;
                pre = ratings[i] == ratings[i-1]? 1:pre+1;
                sum += pre;
                increase = pre;
            }
            else{
                decrease++;
                if(decrease == increase)
                {
                    decrease++;
                }
                sum += decrease;
                pre = 1;
            }
        }
        return sum;

    }
}

package interview.math;

import java.util.Random;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/28 21:20
 */
public class Rand7ToRand10 {

    public  int rand10() {
        while(true){
            int rand49 = (rand7() - 1) * 7 + rand7() - 1;
            if(rand49 <= 39) {
                return rand49 / 4 + 1;
            }
        }
    }

    public int rand7(){
        return new Random(System.currentTimeMillis()).nextInt(7)+1;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<100;i++){
            System.out.println(new Rand7ToRand10().rand7());
            Thread.sleep(10);

        }
    }
}


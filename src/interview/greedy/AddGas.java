package interview.greedy;

public class AddGas {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int remain = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++)
        {
            remain += gas[i]-cost[i];
            if(remain<min)
            {
                index = i;
                min = remain;
            }
        }
        return remain>=0? (index+1)%n:-1;
    }
}


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         
        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            total += gain;
            tank  += gain;

            if (tank < 0) {      // can't reach i+1 from current start
                start = i + 1;   // try next station as start
                tank = 0;        // reset running tank
            }
        }

        // was: return total >= 0 ? start : -1;
        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
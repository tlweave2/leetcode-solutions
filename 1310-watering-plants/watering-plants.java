class Solution {
    public int wateringPlants(int[] plants, int capacity) {
 
        int steps = 0;
        int water = capacity; // start full at the river (-1)

        for (int i = 0; i < plants.length; i++) {
            // If not enough water for plant i, go back to river and return:
            // Going from position i-1 back to -1 takes i steps,
            // and from -1 to i takes i + 1 steps,
            // total "refill trip" cost = (i) + (i + 1) = 2*i + 1 steps.
            // Then we water the plant at i (we're standing on it).
            if (water < plants[i]) {
                steps += 2 * i + 1;  // back to river and return to i, then water here
                water = capacity - plants[i];
            } else {
                // Enough water: just move one step from i-1 to i and water
                steps += 1;          // step forward from previous position to i
                water -= plants[i];
            }
        }
        return steps;
    }
}

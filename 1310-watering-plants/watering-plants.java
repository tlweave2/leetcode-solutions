class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int actions= 0;
        int water = capacity;
        int currentPos = -1;
        for(int i =0; i < plants.length;i++){
            int needed = plants[i];
            if(water < needed){
                actions += Math.abs(currentPos - (-1));
                currentPos = -1;
                water = capacity;
               

            } 
            actions += Math.abs(currentPos - i);
            currentPos = i;
            
            water -= needed;
        }
return actions;
    }
}
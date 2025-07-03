class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length -1;
    for(int i = len; i >= 0 ; i--){
       if(digits[i] != 9){
        digits[i] = digits[i] +1;
       return digits;        

       } 
        digits[i] = 0;
    }
      
      int[] nines = new int[digits.length +1];
      nines[0] =1;
    return nines;
    }
}
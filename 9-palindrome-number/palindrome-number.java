class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 )return false;
        if (x < 10)return true;
        char[] ca = String.valueOf(x).toCharArray();
        int j = ca.length -1;
        int i = 0;
        while(i < j){
        if(ca[i] != ca[j]){
            return false;
        }
        i++;
        j--;

        }
return true;
    }

}
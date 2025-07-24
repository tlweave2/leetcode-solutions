class Solution:
    def convertToBase7(self, num: int) -> str:
        if num == 0:
            return "0"
    
        digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        result = ""
        negative = num < 0
        num = abs(num)
        while num > 0:
            result = digits[num % 7] + result
            num //= 7
    
        return "-" + result if negative else result

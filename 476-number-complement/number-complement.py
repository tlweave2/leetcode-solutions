class Solution:
    def findComplement(self, num: int) -> int:
        # Get binary string and remove '0b' prefix
        binary_str = bin(num)[2:]
        
        # Flip each bit
        flipped = ''.join('1' if bit == '0' else '0' for bit in binary_str)
        
        # Convert back to integer
        return int(flipped, 2)
class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        def process(string):
            result = []
            for char in string:
                if char == '#':
                    if result:
                        result.pop()
                else:
                    result.append(char)
            return result
        return process(s) == process(t)
        
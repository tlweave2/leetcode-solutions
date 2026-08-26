class RandomizedSet:

    def __init__(self):
        self.numMap = {}
        self.numlist = []

    def insert(self, val: int) -> bool:
        res = val not in self.numMap
        if res:
            self.numMap[val] = len(self.numlist)
            self.numlist.append(val)
        return res
        

    def remove(self, val: int) -> bool:
        res = val in self.numMap
        if res:
            idx = self.numMap[val]
            lastval = self.numlist[-1]
            self.numlist[idx]= lastval
            self.numlist.pop()
            self.numMap[lastval] =idx
            del self.numMap[val]
        return res
    def getRandom(self) -> int:
        return random.choice(self.numlist)
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
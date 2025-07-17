class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        # Convert deadends to set for O(1) lookup
        dead_set = set(deadends)
        
        if "0000" in dead_set:
            return -1
        
        # Early exit if already at target
        if target == "0000":
            return 0
            
        def children(lock):
            res = []
            for i in range(4):
                digit = int(lock[i])  # FIX: Store the digit value
                
                # Turn wheel up (with wrap around: 9 -> 0)
                up = (digit + 1) % 10
                res.append(lock[:i] + str(up) + lock[i+1:])
                
                # Turn wheel down (with wrap around: 0 -> 9)  
                down = (digit - 1) % 10
                res.append(lock[:i] + str(down) + lock[i+1:])
                
            return res
        
        q = deque()
        q.append(["0000", 0])  # FIX: Use tuple or consistent format
        visit = set(["0000"])  # FIX: Add starting position to visited
        
        while q:
            lock, turns = q.popleft()
            
            if lock == target:
                return turns
                
            for child in children(lock):
                # FIX: Check conditions before adding to visited/queue
                if child not in dead_set and child not in visit:
                    visit.add(child)
                    q.append([child, turns + 1])  # FIX: Increment turns
        
        return -1  # FIX: Return -1 if target unreachable

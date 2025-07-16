def getNeighbors(combination):
    """
    Generate all possible combinations one turn away.
    For each position, can turn digit up or down.
    """
    neighbors = []
    
    for i in range(4):  # 4 positions
        digit = int(combination[i])
        
        # Turn up (with wrapping: 9 -> 0)
        up_digit = (digit + 1) % 10
        up_combo = combination[:i] + str(up_digit) + combination[i+1:]
        neighbors.append(up_combo)
        
        # Turn down (with wrapping: 0 -> 9)
        down_digit = (digit - 1) % 10
        down_combo = combination[:i] + str(down_digit) + combination[i+1:]
        neighbors.append(down_combo)
    
    return neighbors

class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        dead_set = set(deadends)
        
        # If start or target is a deadend, impossible
        if "0000" in dead_set or target in dead_set:
            return -1
        
        # If already at target
        if target == "0000":
            return 0
        
        # BFS setup
        queue = deque([("0000", 0)])  # (combination, turns)
        visited = {"0000"}
        
        while queue:
            current, turns = queue.popleft()
            
            # Generate all possible next combinations
            for next_combo in getNeighbors(current):  # No self needed now
                # Skip if deadend or already visited
                if next_combo in dead_set or next_combo in visited:
                    continue
                
                # Found target!
                if next_combo == target:
                    return turns + 1
                
                # Add to queue for further exploration
                visited.add(next_combo)
                queue.append((next_combo, turns + 1))
        
        return -1  # Target unreachable
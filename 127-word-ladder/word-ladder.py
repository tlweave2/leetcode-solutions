class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
      
        if endWord not in wordList:
            return 0
        
        # Step 2: Convert wordList to set for O(1) lookup
        # Python tip: set() is much faster for "in" operations than list
        word_set = set(wordList)
        
        # Step 3: BFS setup
        # Queue stores: (current_word, steps_taken)
        queue = deque([(beginWord, 1)])  # Start with 1 step (beginWord counts)
        visited = set([beginWord])  # Track visited words to avoid cycles
        
        # Step 4: BFS main loop
        while queue:
            current_word, steps = queue.popleft()  # Python: popleft() for BFS
            
            # Step 5: Try all possible single-letter changes
            for i in range(len(current_word)):
                # Try changing each position to every letter a-z
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    # Skip if same letter (no change)
                    if c == current_word[i]:
                        continue
                    
                    # Create new word by changing one letter
                    # Python string slicing: word[:i] + c + word[i+1:]
                    new_word = current_word[:i] + c + current_word[i+1:]
                    
                    # Found the target!
                    if new_word == endWord:
                        return steps + 1
                    
                    # If valid word and not visited, add to queue
                    if new_word in word_set and new_word not in visited:
                        visited.add(new_word)
                        queue.append((new_word, steps + 1))
        
        # No path found
        return 0

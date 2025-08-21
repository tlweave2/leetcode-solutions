class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        """
        
        
        
        Space: O(1) if sorting in-place
        """
        # Fix 1: sort() returns None, it sorts in-place
        players.sort()
        trainers.sort()
        
        matches = 0
        trainer_idx = 0
        
        # Fix 2: iterate through players, not the None value from sort()
        for player_ability in players:
            # Find the first trainer who can train this player
            while trainer_idx < len(trainers) and trainers[trainer_idx] < player_ability:
                trainer_idx += 1
            
            # If we found a suitable trainer
            if trainer_idx < len(trainers):
                matches += 1
                trainer_idx += 1  # This trainer is now used
        
        return matches

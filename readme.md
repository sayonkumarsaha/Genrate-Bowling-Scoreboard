# **Bowling Scoreboard**


Summer 2017: Single-player bowling simulation to display scoreboard as text update after every roll. Striving for good code-qualities: object-oriented programming	principles,	clean code,	design patterns, testing, etc.

### Rules of the Game  
 
- Every game consists of 10 rounds 
- In every round, the player has two tosses 
- In the first toss, the player can randomly bowl at most 10 pins 
- In the second toss, the player can bowl randomly another (10 – number of bowled pins from the first toss) pins 
- The score per round is calculated based on the number of bowled pins + additional bonuses if a strike or spare was achieved. 
- A strike is accomplished when all 10 pins are bowled in the first toss already. 
- A spare is accomplished when all 10 pins are bowled in two tosses. 
- The bonus for a spare round is calculated based on the bowled pins of the first toss from the next round. 
- The bonus for a strike round is calculated based on the bowled pins of the next round. 
- In the very last round (i.e., round 10) a player may have an additional third toss, if he again achieved a strike or spare within this round. 

### Test case

Found in *Bowling Programming Task.pdf*
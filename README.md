# Battleship-game
Experiment Report
Player Strategies
For each of 3 strategies you implemented, name the strategy, and then description of it (100 words each)

Strategy 1: Random Placement; In this strategy, ships are placed randomly on the game board. This approach introduces an element of unpredictability, making it harder for opponents to anticipate the ship locations. While it lacks a structured formation, the randomness can create challenges for the opponent's targeting strategy.

Strategy 2: Connecting Ships; This strategy involves placing ships in a manner that connects them, forming larger ship structures. By linking ships together, it adds a layer of complexity to the opponent's task, as hitting one part of a connected ship may reveal the presence of an even larger vessel. This method aims to confuse and mislead opponents by presenting unconventional ship configurations.

Strategy 3: Even Distribution; The even distribution strategy focuses on spreading ships uniformly across the board. This approach minimizes the chances of concentrated hits in one area, making it difficult for the opponent to rapidly locate and sink multiple ships. By evenly dispersing the fleet, this strategy aims to maintain a defensive balance, requiring opponents to explore the entire grid systematically, which can be time-consuming and strategic.

Procedure

The experiment was designed to assess the effectiveness of three different player strategies in the game of Battleship. Three distinct loops were implemented to compare each strategy against the others.

The first loop involved pitting Strategy 1 (Random Placement) against Strategy 2 (Connecting Ships) across 100 trials. Each trial involved running the game with these strategies to evaluate which strategy resulted in more victories. The second loop focused on Strategy 1 versus Strategy 3 (Even Distribution), and similarly, the third loop compared Strategy 2 against Strategy 3. The goal was to observe and analyze the outcomes to determine the relative success rates of the different strategies.

For each trial, the chosen strategies were implemented, and the game was allowed to run until one player achieved victory by sinking all the opponent's ships. The experiment aimed to provide insights into which strategy was more effective in terms of winning matches over multiple iterations.

The primary data collected during the experiment was the number of wins for each strategy in the respective matchups. This data allowed for a quantitative comparison of the success rates of the strategies against each other. The experiment was structured to provide a comprehensive understanding of the relative performance of the three strategies, shedding light on their strengths and weaknesses in different matchups. The use of 100 trials per comparison helped ensure statistical robustness and reliability in drawing conclusions about the strategies' comparative effectiveness.

Results

After conducting a series of simulations to evaluate the performance of three different player strategies in the game of Battleship, we observed intriguing results. The strategies were tested in pairs across 100 trials each, and the data reveals distinctive patterns in their effectiveness.

Strategy 3 emerged as the most effective, showcasing a consistent win rate of nearly 70% against both Strategy 1 and Strategy 2. This suggests that the even distribution of ships across the board provides a strategic advantage, making it challenging for opponents to locate and sink the fleet.

While Strategy 1 had a moderate success rate against Strategy 2, it struggled against the more structured Strategy 3. The randomness introduced in ship placement proved to be effective in some scenarios but lacked the consistency demonstrated by Strategy 3.

Strategy 2 displayed the least effectiveness in the simulations, achieving roughly equal success rates against Strategy 1 and Strategy 3. The attempt to create larger ship structures by connecting them did not consistently outperform the other strategies.

Example Table:

Strategies (x Vs y)	Winrate (x)	Winrate (y)
1 Vs 2	63	37
1 Vs 3	29	71
2 Vs 3	32	68

# XO-Game
Overview
This project is a Tic-Tac-Toe Tournament game where players compete to achieve a winning streak on an n x n board. Players can be either human or automated, with the latter employing various strategies. The game supports multiple rounds and can be played in a console-rendered mode or without rendering.

Features
Supports human and automated players.
Customizable board size and winning streak length.
Tournament mode with a configurable number of rounds.
Choice of rendering the game board to the console or not.
Automated players with different levels of intelligence (Whatever, Clever, Genius).
How to Play
At the start of the game, choose the types of the two players: human or automated (with various levels of intelligence).
Specify the number of rounds, board size, winning streak length, and rendering option.
Players take turns to place their marks (X or O) on the board.
A player wins a round by achieving the specified winning streak.
The tournament summary displays the number of rounds won by each player and the number of ties.
Installation
Ensure you have Java installed on your system.
Clone or download the game repository from GitHub.
Running the Game
Open your terminal or command prompt.
Navigate to the directory where the game files are located.
Compile the game using the command:
bash
Copy code
javac Tournament.java
Run the game using the command:
bash
Copy code
java Tournament [round count] [size] [win_streak] [render target: console/none] [first player: human/whatever/clever/genius] [second player: human/whatever/clever/genius]
Example Commands
Run a tournament with 10,000 rounds, a 4x4 board, a winning streak of 3, no rendering, between a Whatever and Clever player:
bash
Copy code
java Tournament 10000 4 3 none whatever clever
Play 3 rounds on a 4x4 board with a winning streak of 3, rendering the board, between a human and a Whatever player:
bash
Copy code
java Tournament 3 4 3 console human whatever
Input Validation
If an invalid player type or renderer is entered, the program will prompt the user to choose a valid option.
For example:
bash
Copy code
java Tournament 3 4 3 console whtever human
Will result in:
less
Copy code
Choose a player, and start again.
The players: [human, clever, whatever, genius]
Classes and Interfaces
Interfaces
Renderer
Player
Classes
Board
VoidRenderer
ConsoleRenderer
KeyboardInput
HumanPlayer
CleverPlayer
WhateverPlayer
GeniusPlayer
Game
Tournament
PlayerFactory
RendererFactory
Constants
enum Mark
Contributions
Contributions are welcome! Please fork the repository and submit a pull request with your improvements.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Contact
For any questions or support, please open an issue on the GitHub repository or contact the project maintainer.

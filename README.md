## XO-Game

## Overview
This project involves implementing the Tic-Tac-Toe game in Java, as part of an exercise for the Object-Oriented Programming (OOP) course. This project is a modified version of a Tic-Tac-Toe Tournament game where players compete to achieve a winning streak on an n x n board. Players can be either human or automated, with the latter employing various strategies. The game supports multiple rounds and can be played in a console-rendered mode or without rendering.

## Features
- Supports human and automated players.
- Customizable board size and winning streak length.
- Tournament mode with a configurable number of rounds.
- Choice of rendering the game board to the console or not.
- Automated players with different levels of intelligence (Whatever, Clever, Genius).

## How to Play
1. At the start of the game, choose the types of the two players: human or automated (with various levels of intelligence).
2. Specify the number of rounds, board size, winning streak length, and rendering option.
3. Players take turns to place their marks (`X` or `O`) on the board.
4. A player wins a round by achieving the specified winning streak.
5. The tournament summary displays the number of rounds won by each player and the number of ties.

## Installation
1. Ensure you have Java installed on your system.
2. Clone or download the game repository from [GitHub](https://github.com/jamilbar/XO-Game).

## Running the Game
- Open your terminal or command prompt.
- Navigate to the directory where the game files are located.
- Compile the game using the command:
- Run the game using commands like:
- Run a tournament with 10,000 rounds, a 4x4 board, a winning streak of 3, no rendering, between a Whatever and Clever player:
  ```
  java Tournament 10000 4 3 none whatever clever
  ```
- Play 3 rounds on a 4x4 board with a winning streak of 3, rendering the board, between a human and a Whatever player:
  ```
  java Tournament 3 4 3 console human whatever
  ```
## Contributions
Contributions are welcome! Please fork the repository and submit a pull request with your improvements.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Contact
For any questions or support, please open an issue on the GitHub repository or contact the project maintainer.

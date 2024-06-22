/**
 * The Game class represents a game between two players.
 */
public class Game {
    private Player playerX;
    private Player playerO;
    private Renderer renderer;
    private int size;
    private int winStreak;
    private Board board;

    /**
     * A constructor
     * @param playerX instance of Player
     * @param playerO instance of Player
     * @param renderer instance of Renderer.
     */
    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.board = new Board();
        this.winStreak = 3;

    }
    /**
     * A constructor
     * @param playerX instance of Player
     * @param playerO instance of Player
     * @param size the size of the board.
     * @param winStreak Win Streak.
     * @param renderer instance of Renderer.
     */
    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        this.playerX = playerX; this.playerO = playerO; this.size = size; this.winStreak = winStreak;
        this.renderer = renderer;
        this.board = new Board(this.size);
        if (this.winStreak >= this.size || this.winStreak < 2) {
            this.winStreak = this.size;
            System.out.println(this.winStreak);
        }
    }
    /**
     * A public method that returns the Win Streak.
     * @return the winStreak
     */
    public int getWinStreak(){
        return this.winStreak;
    }

    /**
     * A public method that returns the board size
     * @return board size.
     */
    public int getBoardSize(){
        return this.size;
    }

    /**
     *A public method that run one game between two players until someone win or the board is full and
     * the game end with tie.
     * @return winner mark or BLANK for a draw.
     */
    public Mark run(){
        while (true){
            if (!board_not_full()){
                break;
            }
            this.playerX.playTurn(this.board, Mark.X);
            if (player_win(Mark.X) == Mark.X){
                break;
            }
            this.renderer.renderBoard(this.board);
            if (!board_not_full()){
                break;
            }
            this.playerO.playTurn(this.board, Mark.O);
            if ( player_win(Mark.O) == Mark.O){
                break;
            }
            this.renderer.renderBoard(this.board);
        }
        if (player_win(Mark.X) == Mark.X){
            this.renderer.renderBoard(this.board);
            return Mark.X;
        }
        if (player_win(Mark.O) == Mark.O){
            this.renderer.renderBoard(this.board);
            return Mark.O;
        }
        return Mark.BLANK;
    }

    /**
     *A private method that deiced if the player win the game.
     * @param mark the player's mark
     * @return winner mark or Blank for no winner.
     */
    private Mark player_win(Mark mark){
        int len = this.board.getSize();
        if (direction_horizontal(mark, len) == mark || direction_vertical(mark, len) == mark ||
                direction_diagonal_forward(mark, len) == mark ||
                direction_diagonal_backwards(mark, len) == mark){
            return mark;
        }
        return Mark.BLANK;
    }
    /**
     * A private method that check if the board is not full.
     * @return true if the board is not full.Otherwise, false.
     */
    private boolean board_not_full(){
        for (int row = 0; row < this.board.getSize(); row++){
            for (int col = 0; col < this.board.getSize(); col++){
                if (this.board.getMark(row, col) == Mark.BLANK){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * A private method that check if there is a winner on the horizontal direction.
     * @param mark the player's mark
     * @param len the length of the board.
     * @return the winner mark if there is a winner.Otherwise, BLANK.
     */
    private Mark direction_horizontal(Mark mark, int len){
        for (int row = 0; row < len; ++row){
            for (int col = 0; col < len; ++col){
                if (this.board.getMark(row, col) == mark){
                    int counter = 1;
                    for (int index = col + 1; index < col + this.winStreak && index < len; ++index){
                        if (this.board.getMark(row, index) != mark){
                            break;
                        }
                        counter++;
                    }
                    if (counter == this.winStreak){
                        return mark;
                    }
                }
            }
        }
        return Mark.BLANK;
    }

    /**
     * A private method that check if there is a winner on the vertical direction.
     * @param mark the player's mark
     * @param len the length of the board.
     * @return the winner mark if there is a winner.Otherwise, BLANK.
     */
    private Mark direction_vertical(Mark mark, int len){
        for (int col = 0; col < len; ++col){
            for (int row = 0; row < len; ++row){
                if (this.board.getMark(row, col) == mark){
                    int counter = 1;
                    for (int index = row + 1; index < row + this.winStreak && index < len; ++index){
                        if (this.board.getMark(index, col) != mark){
                            break;
                        }
                        counter++;
                    }
                    if (counter == this.winStreak){
                        return mark;
                    }
                }
            }
        }
        return Mark.BLANK;
    }
    /**
     * A private method that check if there is a winner on the diagonal direction.(from up to down)
     * @param mark the player's mark
     * @param len the length of the board.
     * @return the winner mark if there is a winner.Otherwise, BLANK.
     */
    private Mark direction_diagonal_forward(Mark mark, int len){
        for (int row = 0; row < len; ++row){
            for (int col = 0; col < len; ++col){
                if (this.board.getMark(row, col) == mark){
                    int counter = 1;
                    int another_col = col + 1;
                    int another_row = row + 1;
                    while (another_col < len && another_row < len && another_col < col + this.winStreak){
                        if (this.board.getMark(another_row , another_col) != mark){
                            break;
                        }
                        counter++;
                        another_col++;
                        another_row++;
                    }
                    if (counter == this.winStreak){
                        return mark;
                    }
                }
            }
        }
        return Mark.BLANK;
    }
    /**
     * A private method that check if there is a winner on the diagonal direction.(from down to up)
     * @param mark the player's mark
     * @param len the length of the board.
     * @return the winner mark if there is a winner.Otherwise, BLANK.
     */
    private Mark direction_diagonal_backwards(Mark mark, int len){
        for (int row = 0; row < len; ++row){
            for (int col = 0; col < len; ++col){
                if (this.board.getMark(row, col) == mark){
                    int counter = 1;
                    int another_col = col - 1;
                    int another_row = row + 1;
                    while (another_col >= 0 && another_row < len && another_col > col - this.winStreak){
                        if (this.board.getMark(another_row , another_col) != mark){
                            break;
                        }
                        counter++;
                        another_col--;
                        another_row++;
                    }
                    if (counter == this.winStreak){
                        return mark;
                    }
                }
            }
        }
        return Mark.BLANK;
    }
}

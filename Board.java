/**
 * Board class represent a game board for two players.
 * The Board class store the placement of marks made by players on the board.
 */
public class Board {
    /**
     * The board default size in digits. It's a constant.
     */
    public final static int DEFAULT_BOARD_SIZE = 4;
    private Mark[][] board;
    /**
     * A default constructor.
     */
    public Board() {
        this.board = new Mark[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
        this.init_board(DEFAULT_BOARD_SIZE);
    }

    /**
     * A constructor
     * @param size the size of the Board.This size will be used to initializes the board.
     */
    public Board(int size){
        this.board = new Mark[size][size];
        this.init_board(size);
    }
    /**
     * A private method that initializes the Board and used by the constructor.
     * @param size the size of the Board
     */
    private void init_board(int size){
        for (int row = 0; row < size; ++row){
            for (int col = 0; col < size; ++col){
                this.board[row][col] = Mark.BLANK;
            }
        }
    }

    /**
     * A public method that returns the board's length.
     * @return board's length.
     */
    public int getSize(){
        return this.board.length;
    }
    /**
     * A public method that places the mark in the board  if the given coordination is legal.
     * @param mark the mark to place on the board
     * @param row row index for placement
     * @param col column index for placement
     * @return false if the coordination is legal and the position is not occupied otherwise, true
     */
    public boolean putMark(Mark mark, int row, int col){
        if (row >= this.getSize() || col >= this.getSize() || row < 0 || col < 0){
            return false;
        }
        if (this.board[row][col] == Mark.BLANK){
            this.board[row][col] = mark;
            return true;
        }
        return false;
    }
    /**
     * A public method that returns the mark in the given position, if the coordination are legal
     * @param row row index
     * @param col column index
     * @return Blank if the position is illegal.Otherwise, return the mark in the given position.
     */
    public Mark getMark(int row, int col){
        if (row >= this.getSize() || col >= this.getSize() || row < 0 || col < 0){
            return Mark.BLANK;
        }
        return this.board[row][col];
    }

}

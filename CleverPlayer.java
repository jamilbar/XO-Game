/**
 * The CleverPlayer class is an implementation of Player interface.This class represent a clever player
 * that tries to make a move by placing its mark in the first available position,
 * iterating column by column, until a valid move is made.
 */
public class CleverPlayer implements Player{
    /**
     * A default constructor.
     */
    public CleverPlayer() {}
    /**
     * A public method that tries to place the mark on the board by iterating over each column until a valid
     * move. It starts from the first row and first column and moves column by column, until it finds
     * an empty spot.(the method iterate over rows only if the column reaches the board size)
     * @param board the game board
     * @param mark the mark to put on the board.
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int row = 0;
        int col = 0;
        while (true){
            if (!board.putMark(mark, row, col)){
                col++;
                if (col == board.getSize()){
                    col = 0;
                    row++;
                }
                continue;
            }
            break;
        }

    }
}

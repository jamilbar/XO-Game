/**
 * The GeniusPlayer class is an implementation of the Player interface.The Genius Player tries to make a move
 * by iterating over the board, avoiding occupied positions and putting the mark next to same mark
 * on the same row or the same column.
 */
public class GeniusPlayer implements Player{
    /**
     *A default constructor
     */
    public GeniusPlayer() {}
    /**
     * A public method that tries to place the mark on the board by avoiding occupied positions and putting
     * the mark next to same mark on the same row or the same column.If the row or the column reaches
     * the board size the player put the mark in the first empty position
     * @param board the game board
     * @param mark the mark to put on the board.
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int row = 0;
        int col = 0;
        boolean flag = false;
        while (true){
            if (row == board.getSize() || col == board.getSize()) {
                for (int i = 0; i < board.getSize(); ++i) {
                    for (int j = 0; j < board.getSize(); ++j) {
                        if (board.putMark(mark, i, j)) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                break;
            }
            else if (!board.putMark(mark, row, col)){
                if (board.getMark(row, col) == mark){
                    row++;
                }else{
                    col ++;
                }
            }else {
                break;
            }
        }
    }
}

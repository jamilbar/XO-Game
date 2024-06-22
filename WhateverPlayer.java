import java.util.Random;
/**
 *This class represent the Whatever player that put mark randomly on the board
 */
public class WhateverPlayer implements Player{
    Random random;

    /**
     *A default constructor
     */
    public WhateverPlayer() {
        this.random = new Random();
    }

    /**
     * A public method the put the mark randomly on the board.
     * @param board the board game
     * @param mark the player's mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        while (true){
            int row = random.nextInt(board.getSize());
            int col = random.nextInt(board.getSize());
            if(!board.putMark(mark, row, col)){
                continue;
            }
            break;
        }
    }
}

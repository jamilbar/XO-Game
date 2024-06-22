
/**
 * An interface that have one public method, all the classes that implement this interface have to implement
 * the playTurn methods
 */
public interface Player {
    /**
     * a method that play one turn according to the player type
     * @param mark the player's mark
     * @param board the game board.
     */
    void playTurn(Board board, Mark mark);
}

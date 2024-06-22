/**
 * The HumanPlayer class is an implementation of the Player interface. This class put the mark according
 * to the human input that receive the position from the console.
 */
public class HumanPlayer implements Player{
    /**
     *Default constructor
     */
    public HumanPlayer() {}

    /**
     * A public method that put the mark on the board according to the position
     * that we write in the console.
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        if (mark == Mark.X){
            System.out.println(Constants.playerRequestInputString(Constants.MARK_X));
        }
        if (mark == Mark.O){
            System.out.println(Constants.playerRequestInputString(Constants.MARK_O));
        }
        int coordinates;
        int row;
        int col;
        while (true){
            coordinates = KeyboardInput.readInt();
            row = coordinates / 10;
            col = coordinates % 10;
            if (row >= board.getSize() || col >= board.getSize()){
                System.out.println(Constants.INVALID_COORDINATE);
                continue;
            }
            if (!board.putMark(mark, row, col)){
                System.out.println(Constants.OCCUPIED_COORDINATE);
                continue;
            }
            break;
        }
    }
}

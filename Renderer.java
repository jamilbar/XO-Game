/**
 * An interface that have one method.All the classes that implements this interface have to implement
 * the renderBoard methods
 */
public interface Renderer {
    /**
     * A public method that receive a board and draws it.
     */
    void renderBoard(Board board);
}

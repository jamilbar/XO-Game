/**
 *This class create an instance of Renderer.
 */
public class RendererFactory {
    /**
     * A default constructor
     */
    public RendererFactory() {}

    /**
     * A public method that create an instance of Renderer according to type
     * @param type the type of the renderer
     * @param size the size of the board.
     * @return an instance of Renderer.
     */
    public Renderer buildRenderer(String type, int size){
        Renderer renderer = null;
        if (type.equalsIgnoreCase(Constants.NONE)){
            renderer = new VoidRenderer();
        }else if (type.equalsIgnoreCase(Constants.CONSOLE)){
            renderer = new ConsoleRenderer(size);
        }
        return renderer;
    }
}

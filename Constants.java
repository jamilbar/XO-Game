public class Constants {
    public final static String MARK_X = "X";
    public final static String MARK_O = "O";
    public final static String RESULTS = "######### Results #########";
    public final static String HUMAN = "human";
    public final static String CLEVER = "clever";
    public final static String GENIUS = "genius";
    public final static String WHATEVER = "whatever";
    public final static String CONSOLE = "console";
    public final static String NONE = "none";

    public final static String UNKNOWN_PLAYER_NAME = "Choose a player, and start again.\nThe" +
            " players: [human, clever, whatever, genius]";

    public final static String UNKNOWN_RENDERER_NAME = "Choose a renderer, and start again. \n" +
            "Please choose one of the following [console, none]";

    public final static String INVALID_COORDINATE = "Invalid mark position, please choose a different" +
            " position.\n" +
            "Invalid coordinates, type again: ";

    public final static String OCCUPIED_COORDINATE = "Mark position is already occupied.\n" +
            "Invalid coordinates, type again: ";

    /**
     * Use this method to generate the text that HumanPlayer should send
     *
     * @param markSymbol according to the Mark the player uses in the current turn.
     * @return String to be printed to the player.
     */
    public static String playerRequestInputString(String markSymbol) {
        return "Player " + markSymbol + ", type coordinates: ";

    }
}

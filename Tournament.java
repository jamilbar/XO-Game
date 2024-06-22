
/**
 *This class represent a tournament game.
 */
public class Tournament {
    private int rounds;
    private Renderer renderer;
    private Player player1;
    private Player player2;

    /**
     * A constructor
     * @param rounds represent the number of rounds to play
     * @param renderer if console draw the board, if none don't draw
     * @param player1 instance of Player
     * @param player2 instance of Player
     */
    public Tournament(int rounds, Renderer renderer, Player player1, Player player2) {
        this.rounds = rounds;
        this.renderer = renderer;
        this.player1 = player1;
        this.player2 = player2;
    }
    /**
     * A public method that play a Tournament, in even rounds the player1 starts the game, in odd rounds
     * player2 starts.
     * @param size the size of the board
     * @param winStreak Win Streak
     * @param playerName1 the name of the first player.
     * @param playerName2 the name of the second player.
     */
    public void playTournament(int size, int winStreak, String playerName1, String playerName2){
        int index = 0;
        int player1_wins = 0;
        int player2_wins = 0;
        int ties = 0;
        while (index < this.rounds){
            if (index % 2 == 0){
                Game game = new Game(this.player1, this.player2, size, winStreak, this.renderer);
                Mark mark = game.run();
                if (mark == Mark.X){
                    player1_wins++;
                }else if (mark == Mark.O){
                    player2_wins++;
                }else{
                    ties++;
                }

            }else{
                Game game = new Game(this.player2,this.player1, size, winStreak, this.renderer);
                Mark mark = game.run();
                if (mark == Mark.X){
                    player2_wins++;
                }else if (mark == Mark.O){
                    player1_wins++;
                }else{
                    ties++;
                }
            }
            index++;
        }
        System.out.println(Constants.RESULTS);
        System.out.println("Player1, " + playerName1.toLowerCase() + " won: " + player1_wins + " rounds");
        System.out.println("Player2, " + playerName2.toLowerCase() + " won: " + player2_wins + " rounds");
        System.out.println("Ties: " + ties);

    }
    /**
     * The main function, checks the validity of the args and run the game.
     */
    public static void main(String[] args){
        if (!args[3].equalsIgnoreCase(Constants.CONSOLE) && !args[3].equalsIgnoreCase(Constants.NONE)){
        System.out.println(Constants.UNKNOWN_RENDERER_NAME);
        return;
        }
        if (!args[4].equalsIgnoreCase(Constants.HUMAN) && !args[4].equalsIgnoreCase(Constants.CLEVER)
                && !args[4].equalsIgnoreCase(Constants.WHATEVER) &&
                !args[4].equalsIgnoreCase(Constants.GENIUS)){
            System.out.println(Constants.UNKNOWN_PLAYER_NAME);
            return;
        }
        if (!args[5].equalsIgnoreCase(Constants.HUMAN) && !args[5].equalsIgnoreCase(Constants.CLEVER)
                && !args[5].equalsIgnoreCase(Constants.WHATEVER) &&
                !args[5].equalsIgnoreCase(Constants.GENIUS)){
            System.out.println(Constants.UNKNOWN_PLAYER_NAME);
            return;

        }
        int rounds  = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        int winStreak = Integer.parseInt(args[2]);
        PlayerFactory  playerFactory = new PlayerFactory();
        Player player1 = playerFactory.buildPlayer(args[4]);
        Player player2 = playerFactory.buildPlayer(args[5]);
        RendererFactory renderFactory = new RendererFactory();
        Renderer renderer = renderFactory.buildRenderer(args[3], size);
        Tournament tournament = new Tournament(rounds, renderer, player1, player2);
        tournament.playTournament(size, winStreak, args[4], args[5]);
    }

}

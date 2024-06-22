/***
 *The PlayerFactory creat an instance of player.
 */

public class PlayerFactory {
    /**
     * A default constructor.
     */
    public PlayerFactory() {}
    /**
     * A public method that creates an instance of player according to the type
     * @param type name of the player
     * @return an instance of a player.
     */
    public Player buildPlayer(String type){
        Player player = null;
        if (type.equalsIgnoreCase(Constants.HUMAN)){
            player = new HumanPlayer();
        }
        if (type.equalsIgnoreCase(Constants.WHATEVER)){
            player = new WhateverPlayer();
        }
        if (type.equalsIgnoreCase(Constants.CLEVER)){
            player = new CleverPlayer();
        }
        if (type.equalsIgnoreCase(Constants.GENIUS)){
            player = new GeniusPlayer();
        }
        return player;
    }



}

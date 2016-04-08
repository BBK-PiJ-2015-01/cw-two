package mastermind;

/**
* A GameDetailsFactory produces an instance of the game with a certain configuration.
* 
* A GameDetailsFactory produces an instance of the game with a certain configuration.
* The game can have any type of entity and any number of permutations and guesses
*
*/

public interface GameDetailsFactory {

	/**
	* Get an instance of the game
	*
	* @param String: the type of game
	* @return GameInstanceImpl: an instance of the game
	*/
	GameInstanceImpl getGameInstance(String gameType);
}

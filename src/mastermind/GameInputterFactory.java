package mastermind;

/**
* A GameInputterFactory produces an inputter object for the game with a certain configuration.
* 
* A GameInputterFactory produces an inputter object for the game with a certain configuration.
* The game can have any type of entity and needs an appropriate inputter
*
*/

public interface GameInputterFactory {

	/**
	* Get an inputter object for the game
	*
	* @param String: the type of game
	* @return GameInputter: an inputter object for the game
	*/
	GameInputter getGameInputter(String gameType);
}

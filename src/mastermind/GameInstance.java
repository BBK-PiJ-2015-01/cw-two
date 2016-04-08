package mastermind;

/**
* A GameInstance manages the instances of a game.
* 
* A GameInstance manages the instances of a game by generating a secret code,
* controlling the evaluation of attempts and maintaining the game status
*
*/

public interface GameInstance { 

	/**
	* Controls the evaluation of an attempt
	*
	* @param GameAttempt: an attempt
	* @throws NullPointerException if the attempt is null
	* @return GameState: the new state of the game
	*/
	GameState evaluateAttempt(GameAttempt attempt);

	/**
	* Gets the game state
	*
	* @return GameState: the state of the game
	*/
	GameState getGameState(); 

	/**
	* Gets the game details
	*
	* @return GameDetails: the details of the game
	*/
	GameDetails getGameDetails(); 

	/**
	* Gets the number of remaining attempts
	*
	* @return Long: the remaining attempts
	*/
	Long getRemainingAttempts(); 
}

package mastermind;

import java.util.List;

/**
* A GameState encapsulates the state of each running game.
* 
* A GameState encapsulates the state of each running game and
* the history of player attempts at solving the code
*
*/

public interface GameState {
	
	/**
	* Returns the solution.
	*
	* @return List: the solution
	*/
	List<?> getSolution(); 

	/**
	* Set the solution.
	*
	* @param List: the solution
	* @throws IllegalArgumentException if the parameter is null
	*/
	void setSolution(List<?> solution); 

	/**
	* Returns the game status.
	*
	* @return GameStatus: an enumurated type
	*/
	GameStatus getGameStatus(); 

	/**
	* Set the game status.
	*
	* @param GameStatus: the game status
	* @throws IllegalArgumentException if the parameter is null
	*/
	void setGameStatus(GameStatus gameStatus); 

	/**
	* Returns the game history.
	*
	* @return List: the history of attempts
	*/
	List<GameAttempt> getGameHistory(); 

	/**
	* Add an attempt to the history of the running game.
	*
	* @param GameAttempt: the attempt
	* @throws IllegalArgumentException if the parameter is null
	*/
	void addAttempt(GameAttempt attempt); 

	/**
	* Returns the message.
	*
	* @return String: the message
	*/
	String getMessage(); 

	/**
	* Set the message.
	*
	* @param String: the message
	*/
	void setMessage(String message);
}

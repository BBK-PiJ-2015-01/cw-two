package mastermind;

import java.util.LinkedList;
import java.util.List;

/**
* Implementation for the GameState interface.
* 
* A GameState encapsulates the state of each running game and
* the history of player attempts at solving the code
*
**@author Simon Baird & Johannes Neethling
*/

public class GameStateImpl implements GameState {

	private List<?> solution;
	private GameStatus gameStatus;
	private List<GameAttempt> gameHistory = new LinkedList<>();
	private String message;
	//
	private final String NULL_VALUE_MSG = "A null value is not allowed";


	/**
	* {@inheritDoc}
	*/
	@Override
	public List<?> getSolution() {

		return solution;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void setSolution(List<?> solution) {

		if (solution == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		this.solution = solution;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public GameStatus getGameStatus() {

		return gameStatus;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void setGameStatus(GameStatus gameStatus) {

		if (gameStatus == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		this.gameStatus = gameStatus;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public List<GameAttempt> getGameHistory() {

		return gameHistory;
	}
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public void addAttempt(GameAttempt attempt) {

		if (attempt == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		gameHistory.add(attempt);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public String getMessage() {

		return message;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void setMessage(String message) {

		this.message = message;
	}

}

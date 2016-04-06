package mastermind;

import java.util.Collections;
import java.util.List;

/**
* Implementation for the GameAttempt interface.
* 
* A GameAttempt encapsulates each attempt by the player at solving the code,
* the result from evaluation and a message.
*
*@author Simon Baird & Johannes Neethling
*/

public class GameAttemptImpl implements GameAttempt {

	private List<?> attempt = Collections.EMPTY_LIST;
	private AttemptResult attemptResult;
	private String message;
	//
	//
	private final String NULL_VALUE_MSG = "A null value is not allowed";

	/**
	* {@inheritDoc}
	*/
	@Override
	public List<?> getAttempt() {

		return attempt;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void setAttempt(List<?> attempt) {

		if (attempt == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		this.attempt = attempt;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public AttemptResult getAttemptResult() {

		return attemptResult;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void setAttemptResult(AttemptResult result) {

		if (result == null) {
			throw new IllegalArgumentException(NULL_VALUE_MSG);
		}
		attemptResult = result;
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

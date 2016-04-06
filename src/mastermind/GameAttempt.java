package mastermind;

import java.util.List;

/**
* A GameAttempt is a single attempt by the player to solve the code.
* 
* A GameAttempt encapsulates each attempt by the player at solving the code,
* the result from evaluation and a message.
*
*/

public interface GameAttempt {

	/**
	* Returns the user's attempt at solving the code.
	*
	* @return List: the attempt
	*/
	List<?> getAttempt();

	/**
	* Set the user's attempt at solving the code.
	*
	* @param List: the attempt
	* @throws IllegalArgumentException if the parameter is null
	*/
	void setAttempt(List<?> attempt);

	/**
	* Returns the result from evaluation.
	*
	* @return AttemptResult: the result
	*/	
	AttemptResult getAttemptResult();

	/**
	* Set the result for an attempt.
	*
	* @param AttemptResult: the result
	* @throws IllegalArgumentException if the parameter is null
	*/	
	void setAttemptResult(AttemptResult result);

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
